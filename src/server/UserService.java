package server;

import remote.IUser;
import remote.IUserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class UserService extends UnicastRemoteObject implements IUserService {


    private static UserService svc;
    private Map<String, IUser> users;

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
        this.users = new HashMap<String, IUser>();
    }

    @Override
    public boolean isUser(String username) throws RemoteException {
        return users.containsKey(username);
    }

    @Override
    public IUser getUser(String username) throws RemoteException {
        if (isUser(username)) {
            return users.get(username);
        }
        return null;
    }

    public Map<String, IUser> getUsers() throws RemoteException {
        return users;
    }

    @Override
    public void addUser(String username) throws RemoteException {
        users.put(username, new User(username));
    }

    @Override
    public void removeUser(String username) throws RemoteException {
        if (isUser(username)) {
            users.remove(username);
        }
    }

}
