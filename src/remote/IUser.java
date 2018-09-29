package remote;

import server.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IUser extends Remote {

    String getUsername();
    int getScore();

    void createRoom(int roomid, List<IUser> players) throws RemoteException;
    boolean getReply(int roomid) throws RemoteException;
    void enterRoom(Room room) throws RemoteException;

    void setScore(int newScore);
    void getOperation(String letter, int x, int y);
    void vote(String[] words);
    boolean getVoteMessage();

}
