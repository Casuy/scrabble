package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientAgent extends Remote {

    void updateUserList(String json) throws RemoteException;

    void updateRoomState(String json) throws RemoteException;

    void updateGameState(String json) throws RemoteException;

    void updateInvitation(String json) throws RemoteException;

}
