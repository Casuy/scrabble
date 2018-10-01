package client;

import com.google.gson.Gson;
import remote.IGameService;
import remote.IUserService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class ServerService {

    private static ServerService ssvc;
    private static Gson gson = new Gson();
    private static Logger log = Logger.getLogger("Client Log");

    private String serverHost;
    private int serverPort;

    private IUserService userService;
    private IGameService gameService;

    private String username;

    public static ServerService getInstance() {
        if (ssvc == null) {
            ssvc = new ServerService();
        }
        return ssvc;
    }

    public void bindServer(String host, int port) {
        this.serverHost = host;
        this.serverPort = port;
    }

    public void login(String username, String clientHost, int clientPort) throws Exception {
        this.username = username;
        Registry serverRegistry = LocateRegistry.getRegistry(serverHost, serverPort);
        userService = (IUserService) serverRegistry.lookup("UserService");
        gameService = (IGameService) serverRegistry.lookup("GameService");
        try {
            Registry clientRegistry = LocateRegistry.createRegistry(clientPort);
            log.info("Client registry successed.");
            clientRegistry.rebind("Client", ClientAgent.getInstance());
            log.info("Client bind successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.login(username, clientHost, clientPort);
    }

    public void logout() throws Exception {
        userService.logout(username);
    }

    public void createRoom(String username) throws Exception {
        gameService.createRoom(username);
    }

    public void leaveRoom(int roomId, String username) throws Exception {
        gameService.leaveRoom(roomId, username);
    }

    public void roomInvite(int roomId, String invitor, String invitee) throws Exception {
        gameService.roomInvite(roomId, invitor, invitee);
    }

    public void startGame(int roomId) throws Exception {
        gameService.startGame(roomId);
    }

    public void gameSubmit(String username, int y, int x, String v) throws Exception {
        gameService.gameSubmit(username, y, x, v);
    }

    public void gameVote(String username, String wordsJson) throws Exception {
        gameService.gameVote(username, gson.fromJson(wordsJson, String[].class));
    }

    public void acceptRoomInvitation(int roomId, String invitee) throws Exception {
        gameService.acceptRoomInvitation(roomId, invitee);
    }

    public void refuseRoomInvitation(int roomId, String invitee) throws Exception {
        gameService.refuseRoomInvitation(roomId, invitee);
    }

    public void gameExit(int roomId) throws Exception {
        gameService.gameExit(roomId);
    }

}
