package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote {

    String userInfo() throws RemoteException;
    void startGame() throws RemoteException;
    String getUsername() throws RemoteException;

}
