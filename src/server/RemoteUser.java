package server;

import remote.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteUser extends UnicastRemoteObject implements IUser {

    private String username;
    private int score;

    public RemoteUser(String username) throws RemoteException {
        this.username = username;
    }

    @Override
    public String userInfo() throws RemoteException {
        String info = "Username: " + username + "\n Score: " + score;
        return info;
    }

    @Override
    public void startGame() throws RemoteException {
        RemoteGame game = new RemoteGame();
        //game start
    }

    @Override
    public String getUsername() {
        return username;
    }
}
