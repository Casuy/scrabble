package client;

import javafx.application.Platform;
import javafx.scene.web.WebEngine;
import remote.IClientAgent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ClientAgent extends UnicastRemoteObject implements IClientAgent {

    private static ClientAgent agent;
    private boolean viewLock = true;
    private WebEngine webEngine;
    ArrayList<String> scripts = new ArrayList<>();


    private ClientAgent() throws RemoteException {
        super();
    }

    public static ClientAgent getInstance() {
        try {
            if (agent == null) {
                agent = new ClientAgent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agent;
    }

    public void bindEngine(WebEngine webEngine) {
        this.webEngine = webEngine;
        viewLock = false;
        scripts.forEach(this::exec);
        scripts.clear();
    }

    private void exec(String script) {
        Platform.runLater(() ->
                webEngine.executeScript("(window['casuyagentreactor'])." + script)
        );
    }

    private void eval(String script) {
        if (this.viewLock) {
            this.scripts.add(script);
            return;
        }
        exec(script);
    }


    @Override
    public void updateUserList(String json) throws RemoteException {
        eval(String.format("updateUserList('%s')", json));
    }

    @Override
    public void updateRoomState(String json) throws RemoteException {
        eval(String.format("updateRoomState('%s')", json));
    }

    @Override
    public void updateGameState(String json) throws RemoteException {
        eval(String.format("updateGameState('%s')", json));
    }

    @Override
    public void updateInvitation(String json) throws RemoteException {
        eval(String.format("updateInvitation('%s')", json));
    }


}
