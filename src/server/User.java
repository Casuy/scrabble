package server;

import remote.IUser;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class User extends UnicastRemoteObject implements IUser {

    private String username;
    private int score;
    private Room room;

    public User() throws RemoteException {
        super();
    }

    public User(String username) throws RemoteException {
        this.username = username;
        this.score = 0;
        this.room = null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void createRoom(int roomid, List<IUser> players) throws RemoteException {
        this.room = new Room(roomid, players);
        for (IUser player: players) {
            player.enterRoom(room);
        }
    }

    @Override
    public boolean getReply(int roomid) throws RemoteException {
        return false;
    }

    @Override
    public void enterRoom(Room room) throws RemoteException {
        this.room = room;
    }

    @Override
    public void setScore(int newScore) {
        this.score = newScore;
    }

    @Override
    public void getOperation(String letter, int x, int y) {

    }

    @Override
    public void vote(String[] words) {

    }

    @Override
    public boolean getVoteMessage() {
        return false;
    }
}
