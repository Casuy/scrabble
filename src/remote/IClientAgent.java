package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientAgent extends Remote {
    void updateRoomInfo() throws RemoteException;

    void updateGameState() throws RemoteException;

}


