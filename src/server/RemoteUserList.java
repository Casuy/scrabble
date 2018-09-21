package server;

import remote.IUser;
import remote.IUserList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteUserList extends UnicastRemoteObject implements IUserList {
    private List<IUser> userList;

    public RemoteUserList() throws RemoteException {
        userList = new ArrayList<>();
    }

    @Override
    public boolean isUser(String username) throws RemoteException{
        for (IUser user: userList) {
            if (username.equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IUser getUser(String username) throws RemoteException{
        for (IUser user: userList) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public List<IUser> getUserList() throws RemoteException{
        return userList;
    }

    @Override
    public void addUser(String username) throws RemoteException {
        userList.add(new RemoteUser(username));
    }

    @Override
    public void removeUser(String username) throws RemoteException{
        if (isUser(username)) {
            userList.remove(getUser(username));
        }
    }

    @Override
    public void printUserInfos() throws RemoteException {
        for (IUser user: userList) {
            System.out.println(user.userInfo());
        }
    }
}
