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
            log.info("Register successed.");
            registry.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registry;
    }

    public static void bind() {
        Registry registry = createRegistry();
        try {
            RemoteUserList userList = new RemoteUserList();
            registry.rebind("UserList", userList);
            log.info("Bind success.");
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
