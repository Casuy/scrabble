package server;

import remote.IClientAgent;
import remote.ILoginService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginService extends UnicastRemoteObject implements ILoginService {

    private static LoginService svc;
    private static UserService users = UserService.getInstance();
    private Map<String, IClientAgent> clients = new HashMap();

    static LoginService getInstance() {
        try {
            if (svc == null) {
                svc = new LoginService();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return svc;
    }

    public LoginService() throws RemoteException {
    }

    @Override
    public boolean login(String username, String clientHost, int clientPort) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(clientHost, clientPort);
            IClientAgent client = (IClientAgent) registry.lookup("Client");
            clients.put(username, client);
            users.addUser(username);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void logout() throws RemoteException {
    }

    public IClientAgent getClientByUsername(String username) {
        return clients.get(username);
    }

    public IClientAgent getClientByUser(User user) {
        return getClientByUsername(user.getUsername());
    }

    public ArrayList<IClientAgent> getClientsByUsernames(ArrayList<String> usernames) {
        ArrayList<IClientAgent> selectedClients = new ArrayList<>();
        for (String username : usernames) {
            selectedClients.add(getClientByUsername(username));
        }
        return selectedClients;
    }

    public ArrayList<IClientAgent> getClientsByUsers(ArrayList<User> users) {
        ArrayList<IClientAgent> selectedClients = new ArrayList<>();
        for (User u : users) {
            selectedClients.add(getClientByUser(u));
        }
        return selectedClients;
    }

    public ArrayList<IClientAgent> getAllClients() {
        return new ArrayList<IClientAgent>(clients.values());
    }
}
