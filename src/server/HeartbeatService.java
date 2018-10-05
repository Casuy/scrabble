package server;

import remote.IHeartbeatService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HeartbeatService extends UnicastRemoteObject implements IHeartbeatService {

    private static HeartbeatService heartbeatService;
    private static Map<String, Integer> counters = new HashMap<>();

    public HeartbeatService() throws RemoteException {
        super();
    }

    public static HeartbeatService getInstance() {
        try {
            if (heartbeatService == null) {
                heartbeatService = new HeartbeatService();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return heartbeatService;
    }

    @Override
    public void clearCounter(String username) throws RemoteException {
        counters.put(username, 0);
    }

    public Map<String, Integer> getCounters() {
        return counters;
    }

    public void counterIncrement() {
        counters.forEach(
                (k, v) -> {
                    counters.put(k, v + 1);
                }
        );
    }

    public ArrayList<String> getDeadUsernames() {
        ArrayList<String> deadClients = new ArrayList<>();
        counters.forEach((k, v) -> {
            if (v >= 3) {
                deadClients.add(k);
            }
        });
        for (String temp_name : deadClients) {
            counters.remove(temp_name);
        }
        return deadClients;
    }

}

