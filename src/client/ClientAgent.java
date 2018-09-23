package client;

import javafx.scene.web.WebEngine;
import remote.IClientAgent;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientAgent extends UnicastRemoteObject implements IClientAgent {


    private static ClientAgent agent;

    static ClientAgent getInstance() {
        try {
            if (agent == null) {
                agent = new ClientAgent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agent;
    }

    private ClientAgent() throws RemoteException {
    }

    private WebEngine engine;

    public void bindEngine(WebEngine engine) {
        this.engine = engine;
    }

    @Override
    public void updateRoomInfo() throws RemoteException {

    }

    @Override
    public void updateGameState() throws RemoteException {

    }
}
