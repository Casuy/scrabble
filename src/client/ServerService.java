package client;

import com.google.gson.Gson;
import remote.IGameService;
import remote.ILoginService;
import remote.IUserService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerService {
    private static ServerService ourInstance = new ServerService();

    public static ServerService getInstance() {
        return ourInstance;
    }

    private ServerService() {
    }

    private static Gson gson = new Gson();
    private String serverHost;
    private int serverPort;
    private ILoginService loginService;
    private IUserService userService;
    private IGameService gameService;

    public void bindServer(String host, int port) {
        serverHost = host;
        serverPort = port;
    }

    public void login(String username, String clientHost, int clientPort) throws Exception {
        Registry remoteR = LocateRegistry.getRegistry(serverHost, serverPort);
        this.loginService = (ILoginService) remoteR.lookup("LoginService");
        this.userService = (IUserService) remoteR.lookup("UserService");
        this.gameService = (IGameService) remoteR.lookup("GameService");
        try {
            Registry clientR = LocateRegistry.createRegistry(clientPort);
            clientR.rebind("Client", ClientAgent.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.loginService.login(username, clientHost, clientPort);
    }

    public void createRoom(String username) throws Exception {
        this.gameService.createRoom(username);
    }

    public void leaveRoom(int roomId, String username) throws Exception {
        this.gameService.leaveRoom(roomId, username);
    }

    public void roomInvite(int roomId, String invitor, String invitee) throws Exception {
        this.gameService.roomInvite(roomId, invitor, invitee);
    }

    public void startGame(int roomId) throws Exception {
        this.gameService.startGame(roomId);
    }

    public void gameSubmit(String username, int y, int x, String v) throws Exception {
        this.gameService.gameSubmit(username, y, x, v);
    }

    public void gameVote(String username, String wordsJson) throws Exception {
        this.gameService.gameVote(username, gson.fromJson(wordsJson, String[].class));
    }

    public void acceptRoomInvitation(int roomId, String invitee) throws Exception {
        this.gameService.acceptRoomInvitation(roomId, invitee);
    }

    public void refuseRoomInvitation(int roomId, String invitee) throws Exception {
        this.gameService.refuseRoomInvitation(roomId, invitee);
    }

}
