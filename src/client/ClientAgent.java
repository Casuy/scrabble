package client;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.scene.web.WebEngine;
import remote.IClientAgent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ClientAgent extends UnicastRemoteObject implements IClientAgent {


    private static ClientAgent agent;
    private static Gson gson = new Gson();
    boolean viewLock = true;
    private WebEngine engine;
    ArrayList<String> scripts = new ArrayList<>();


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
        super();
    }


    void bindEngine(WebEngine engine) {
        this.engine = engine;
        viewLock = false;
        scripts.forEach(this::_exec);
        scripts.clear();
    }

    private void _exec(String script) {
        Platform.runLater(() -> this.engine.executeScript("(window['casuyagentreactor'])." + script));
    }

    void eval(String script) {
        if (this.viewLock) {
            this.scripts.add(script);
            return;
        }
        _exec(script);
    }

    @Override
    public void updateRoomState(String json) throws RemoteException {
        eval(String.format("updateRoomState('%s')", json));
    }

    @Override
    public void updateUserList(String json) throws RemoteException {
//        System.out.println(json);
        eval(String.format("updateUserList('%s')", json));
    }


    @Override
    public void updateGameState(String json) throws RemoteException {
        System.out.println(json);
        eval(String.format("updateGameState('%s')", json));
    }

    @Override
    public void updateInvitation(String json) throws RemoteException {
//        System.out.println(json);
        eval(String.format("updateInvitation('%s')", json));
    }

}
