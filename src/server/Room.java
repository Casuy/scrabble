package server;

import remote.IRoom;
import remote.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Room extends UnicastRemoteObject implements IRoom {

    private int roomid;
    private List<IUser> players;

    public Room() throws RemoteException {
        super();
    }

    public Room(int roomid, List<IUser> players) throws RemoteException{
        this.roomid = roomid;
        this.players = players;
    }

    @Override
    public List<IUser> getPlayers() throws RemoteException {
        return players;
    }
}
