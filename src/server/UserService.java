package server;

import com.google.gson.Gson;
import remote.IUserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserService extends UnicastRemoteObject implements IUserService {

    private static Gson gson = new Gson();
    private static UserService svc;
    private Map<String, User> users = new HashMap<String, User>();
    private static LoginService loginService = LoginService.getInstance();

    public static UserService getInstance() {
        try {
            if (svc == null) {
                svc = new UserService();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return svc;
    }

    public UserService() throws RemoteException {
    }

    @Override
    public boolean isUser(String username) throws RemoteException {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        try {

            if (isUser(username)) {
                return users.get(username);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Map<String, User> getUsers() throws RemoteException {
        return users;
    }

    @Override
    public void addUser(String username) throws RemoteException {
        users.put(username, new User(username));
        System.out.println(username);
        pushUserListUpdate();
    }

    @Override
    public void removeUser(String username) throws RemoteException {
        if (isUser(username)) {
            users.remove(username);
            pushUserListUpdate();
        }
    }

    public void pushUserListUpdate() {
        loginService.getAllClients().forEach(c -> {
            try {
                c.updateUserList(toJson());
            } catch (Exception ignored) {
            }
        });
    }


    private String toJson() {
        ArrayList<CUser> list = new ArrayList<>();
        users.values().forEach(u -> {
            CUser user = new CUser();
            user.name = u.getUsername();
            list.add(user);
        });
        return gson.toJson(list);
    }


}

class CUser {
    String name;
}
