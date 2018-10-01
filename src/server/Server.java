package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Server {

    private static Logger log = Logger.getLogger("Server Log");
    private static int port = 9999;

    public static void main(String[] args) {
        try {
            bind();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Registry createRegistry() {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(port);
            log.info("Server registry successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registry;
    }

    private static void bind() {
        Registry registry = createRegistry();
        try {
            registry.rebind("UserService", UserService.getInstance());
            registry.rebind("GameService", GameService.getInstance());
            log.info("Server bind successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
