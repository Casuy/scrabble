package client;

import remote.ILoginService;
import remote.IUser;
import remote.IUserService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ServerService {
    private static ServerService ourInstance = new ServerService();

    public static ServerService getInstance() {
        return ourInstance;
    }

    private ServerService() {
    }

    private String serverHost;
    private int serverPort;
    private ILoginService loginService;
    private IUserService userService;

    public void bindServer(String host, int port) {
        serverHost = host;
        serverPort = port;
    }

    public boolean login(String username, String clientHost, int clientPort) throws Exception {
        Registry remoteR = LocateRegistry.getRegistry(serverHost, serverPort);
        this.loginService = (ILoginService) remoteR.lookup("LoginService");
        this.userService = (IUserService) remoteR.lookup("UserService");
        try {
            Registry clientR = LocateRegistry.createRegistry(clientPort);
            clientR.rebind("Client", ClientAgent.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.userService.addUser(username);
        return this.loginService.login(username, clientHost, clientPort);
    }

//    public void prprprcasuy() {
//        System.out.println("prprppr");
////        engine.executeScript('window.casuyagent2.hi()')
//    }

    public boolean createRoom(int roomid, String mastername, List<String> invited) throws Exception {
        List<IUser> players = new ArrayList<>();
        for (String name: invited) {
            IUser player = this.userService.getUser(name);
            if (player.getReply(roomid)) {
                players.add(player);
            } else {
                return false;
            }
        }
        IUser master = this.userService.getUser(mastername);
        players.add(master);
        master.createRoom(roomid, players);
        return true;
    }

}
