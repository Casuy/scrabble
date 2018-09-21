package client;

import javafx.application.Application;
import remote.IUserList;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Logger;

public class Client extends GUI{

    static Logger log = Logger.getLogger("Client log");

    static void getRemoteUser(String username) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", server.Server.port);
        IUserList userList = (IUserList) registry.lookup("UserList");
        userList.addUser(username);
    }

    public static void main(String[] args) {
//        Application.launch();

        try {
            getRemoteUser(args[0]);
            log.info("User created.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
