package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Server {

    static Logger log = Logger.getLogger("Server log");
    public static int port = 9999;

    public static Registry createRegistry() {
        Registry registry = null;

        try {
            registry = LocateRegistry.createRegistry(port);
            log.info("Registry successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registry;
    }

    public static void bind() {
        Registry registry = createRegistry();
        try {
            registry.rebind("UserService", UserService.getInstance());
            registry.rebind("LoginService", LoginService.getInstance());
            log.info("Bind successed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            bind();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
