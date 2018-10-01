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

    private Map<String, IClientAgent> clients = new HashMap<>();

    public LoginService() throws RemoteException {
        super();
    }

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

    @Override
    public void login(String username, String clientHost, int clientPort) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(clientHost, clientPort);
            IClientAgent client = (IClientAgent) registry.lookup("Client");
            clients.put(username, client);
            users.addUser(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logout() throws RemoteException {
    }

    public IClientAgent getClientByUsername(String username) {
        return clients.get(username);
    }


    public ArrayList<IClientAgent> getClientsByUsernames(ArrayList<String> usernames) {
        ArrayList<IClientAgent> selectedClients = new ArrayList<>();
        for (String username : usernames) {
            selectedClients.add(getClientByUsername(username));
        }
        return selectedClients;
    }

    public ArrayList<IClientAgent> getAllClients() {
        return new ArrayList<IClientAgent>(clients.values());
    }
}
