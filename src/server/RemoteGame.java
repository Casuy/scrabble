package server;

import remote.IGame;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteGame extends UnicastRemoteObject implements IGame {
    public RemoteGame() throws RemoteException {
        super();
    }
}
