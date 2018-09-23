package client;

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

    private String serverHost;
    private int serverPort;
    private ILoginService loginService;
    private IUserService userService;

    public void bindServer(String host, int port) {
        serverHost = host;
        serverPort = port;
    }

    public void login(String username, String clientHost, int clientPort) throws Exception {
        Registry remoteR = LocateRegistry.getRegistry(serverHost, serverPort);
        this.loginService = (ILoginService) remoteR.lookup("LoginService");
        this.userService = (IUserService) remoteR.lookup("UserService");
        try {
            Registry clientR = LocateRegistry.createRegistry(clientPort);
            clientR.rebind("Client", ClientAgent.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.loginService.login(username, clientHost, clientPort);
    }

    public void prprprcasuy() {
        System.out.println("prprppr");
//        engine.executeScript('window.casuyagent2.hi()')
    }
}
