package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRoom extends Remote {

    List<IUser> getPlayers() throws RemoteException;

}
