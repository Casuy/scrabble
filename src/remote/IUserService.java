package remote;

import server.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface IUserService extends Remote {

    boolean isUser(String username) throws RemoteException;

    void addUser(String username) throws RemoteException;

    void removeUser(String username) throws RemoteException;
//    Map<String, User> getUsers() throws RemoteException;
//    User getUser(String username) throws RemoteException;
}
