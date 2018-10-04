package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUserService extends Remote {

    boolean isUser(String username) throws RemoteException;

    void login(String username, String clientHost, int clientPort) throws RemoteException;

    void logout(String username) throws RemoteException;

}
