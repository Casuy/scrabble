package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUserList extends Remote {

    boolean isUser(String username) throws RemoteException;
    void addUser(String username) throws RemoteException;
    void removeUser(String username) throws RemoteException;
    void printUserInfos() throws RemoteException;
    List<IUser> getUserList() throws RemoteException;
    IUser getUser(String username) throws RemoteException;
}
