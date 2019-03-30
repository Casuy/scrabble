package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHeartbeatService extends Remote {

    void clearCounter(String username) throws RemoteException;

}
