package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGameService extends Remote {

    void createRoom(String username) throws RemoteException;

    void leaveRoom(int roomId, String username) throws RemoteException;

    void roomInvite(int roomId, String invitor, String invitee) throws RemoteException;

    void acceptRoomInvitation(int roomId, String invitee) throws RemoteException;

    void refuseRoomInvitation(int roomId, String invitee) throws RemoteException;

    void startGame(int roomId) throws RemoteException;

    void gameSubmit(String username, int y, int x, String v) throws RemoteException;

    void gameVote(String username, String[] words) throws RemoteException;

    void gameExit(int roomId) throws RemoteException;

}
