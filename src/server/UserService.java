package server;

import com.google.gson.Gson;
import remote.IClientAgent;
import remote.IUserService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class UserService extends UnicastRemoteObject implements IUserService {

    private static UserService userService;
    private static Gson gson = new Gson();
    private static Logger log = Logger.getLogger("UserService Log");

    private ArrayList<User> users = new ArrayList<>();
    private Map<String, IClientAgent> clients = new HashMap<>();

    public UserService() throws RemoteException {
        super();
    }

    public static UserService getInstance() {
        try {
            if (userService == null) {
                userService = new UserService();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService;
    }

    @Override
    public boolean isUser(String username) throws RemoteException {
        return clients.containsKey(username);
    }

    @Override
    public void login(String username, String clientHost, int clientPort) throws Exception {
//        try {
        Registry registry = LocateRegistry.getRegistry(clientHost, clientPort);
        IClientAgent client = (IClientAgent) registry.lookup("Client");
        clients.put(username, client);
        User user = new User(username);
        user.login();
//        } catch (Exception e) {
//            e.printStackTrace();
//    }

    }

    @Override
    public void exit(String username) throws RemoteException {
        clients.remove(username);
        User u = getUserByUsername(username);
        if (u != null) {
            u.leaveGame();
            u.leaveRoom();
            u.logout();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public Map<String, IClientAgent> getClients() {
        return clients;
    }

    public User getUserByUsername(String username) {
        return users.stream().filter(
                user -> user.getName().equals(username)
        ).findFirst().orElse(null);
    }

    public ArrayList<IClientAgent> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    public IClientAgent getClientByUsername(String username) {
        return clients.get(username);
    }

    public ArrayList<IClientAgent> getClientsByUsernames(ArrayList<String> usernames) {
        ArrayList<IClientAgent> selectedClients = new ArrayList<>();
        usernames.forEach(
                username -> {
                    selectedClients.add(getClientByUsername(username));
                }
        );
        return selectedClients;
    }


}
