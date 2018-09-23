package server;

import remote.IClientAgent;
import remote.ILoginService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class LoginService extends UnicastRemoteObject implements ILoginService {

    private static LoginService svc;

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

    private Map<String, IClientAgent> clients = new HashMap();

    public LoginService() throws RemoteException {
    }


    @Override
    public boolean login(String username, String clientHost, int clientPort) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(clientHost, clientPort);
            IClientAgent client = (IClientAgent) registry.lookup("Client");
            clients.put(username, client);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void logout() throws RemoteException {

    }
}
