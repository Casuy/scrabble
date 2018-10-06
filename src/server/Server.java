package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Server extends Thread {

    private static Logger log = Logger.getLogger("Server Log");
    private static int port = 9999;
    private static UserService userService = UserService.getInstance();
    private static GameService gameService = GameService.getInstance();
    private static HeartbeatService heartbeatService = HeartbeatService.getInstance();

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.bind();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Registry createRegistry() {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(port);
            log.info("Server registry successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registry;
    }

    private void bind() {
        Registry registry = createRegistry();
        try {
            registry.rebind("UserService", userService);
            registry.rebind("GameService", gameService);
            registry.rebind("HeartbeatService", heartbeatService);
            log.info("Server bind successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                heartbeatService.counterIncrement();
                heartbeatService.getDeadUsernames().forEach(username -> {
                    log.warning("Connection to user '" + username + "' interrupted.");
                    try {
                        User user = userService.getUserByUsername(username);
                        if (user.getInGameState()) {
                            gameService.gameExit(user.getId());
                        }
                        if (user.getInRoomState()) {
                            gameService.leaveRoom(user.getId(), username);
                        }
                        userService.exit(username);
                    } catch (Exception e) {
                        log.warning(e.getMessage());
                    }
                    userService.getClients().remove(username, userService.getClientByUsername(username));
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
