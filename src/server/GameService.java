package server;

import remote.IGameService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GameService extends UnicastRemoteObject implements IGameService {
    private static GameService svc;

    static GameService getInstance() {
        try {
            if (svc == null) {
                svc = new GameService();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return svc;
    }

    public GameService() throws RemoteException {
    }


    private ArrayList<Room> rooms = new ArrayList<>();


    @Override
    public void createRoom(String username) throws RemoteException {
        Room r = new Room(username);
        this.rooms.add(r);
    }

    @Override
    public void leaveRoom(int roomId, String username) throws RemoteException {
        Room r = getRoomById(roomId);
        if (r != null) {
            r.leave(username);
        }
    }


    @Override
    public void roomInvite(int roomId, String invitor, String invitee) throws RemoteException {
        Room r = getRoomById(roomId);
        if (r != null) {
            r.inviteUser(invitor, invitee);
        }
    }

    @Override
    public void acceptRoomInvitation(int roomId, String invitee) throws RemoteException {
        Room r = getRoomById(roomId);
        if (r != null) {
            r.acceptInvitation(invitee);
        }
    }

    @Override
    public void refuseRoomInvitation(int roomId, String invitee) throws RemoteException {
        Room r = getRoomById(roomId);
        if (r != null) {
            r.refuseInvitation(invitee);
        }
    }


    @Override
    public void startGame(int roomId) throws RemoteException {
        for (Room r : rooms) {
            if (r.getId() == roomId) {
                r.initGame();
                break;
            }
        }
    }

    public Room getRoomById(int roomId) {
        for (Room room : rooms) {
            if (room.getId() == roomId) {
                return room;
            }
        }
        return null;
    }

    public Room getRoomByUsername(String username) {
        for (Room room : rooms) {
            if (room.getUsers().contains(username)) {
                return room;
            }
        }
        return null;
    }

    private Game getGameFromUsername(String username) {
        Room r = this.getRoomByUsername(username);
        if (r != null) {
            return r.getGame();
        }
        return null;
    }


    @Override
    public void gameSubmit(String username, int y, int x, String v) throws RemoteException {
        Game g = getGameFromUsername(username);
        if (g != null) {
            g.submit(username, y, x, v);
        }
    }

    @Override
    public void gameVote(String username, String[] words) throws RemoteException {
        System.out.println(0);
        System.out.println(username);
        Game g = getGameFromUsername(username);
        if (g != null) {
            System.out.println(1);
            g.vote(username, words);
        }
    }


}
