package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginService extends Remote {

    void login(String username, String clientHost, int clientPort) throws RemoteException;
    void logout() throws RemoteException;

}