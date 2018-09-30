package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClientAgent extends Remote {
    void updateRoomState(String json) throws RemoteException;

    void updateUserList(String json) throws RemoteException;

    void updateGameState(String json) throws RemoteException;

    void updateInvitation(String json) throws RemoteException;

}


