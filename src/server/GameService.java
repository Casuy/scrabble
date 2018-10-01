package server;

import remote.IGameService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GameService extends UnicastRemoteObject implements IGameService {

    private static GameService gameService;

    private ArrayList<Room> rooms = new ArrayList<>();

    public GameService() throws RemoteException {
        super();
    }

    public static GameService getInstance() {
        try {
            if (gameService == null) {
                gameService = new GameService();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameService;
    }

    @Override
    public void createRoom(String username) throws RemoteException {
        Room room = new Room(username);
        rooms.add(room);
    }

    @Override
    public void leaveRoom(int roomId, String username) throws RemoteException {
        Room room = getRoomById(roomId);
        if (room != null) {
            room.leave(username);
        }
    }

    @Override
    public void roomInvite(int roomId, String invitor, String invitee) throws RemoteException {
        Room room = getRoomById(roomId);
        if (room != null) {
            room.inviteUser(invitor, invitee);
        }
    }

    @Override
    public void acceptRoomInvitation(int roomId, String invitee) throws RemoteException {
        Room room = getRoomById(roomId);
        if (room != null) {
            room.acceptInvitation(invitee);
        }
    }

    @Override
    public void refuseRoomInvitation(int roomId, String invitee) throws RemoteException {
        Room room = getRoomById(roomId);
        if (room != null) {
            room.refuseInvitation(invitee);
        }
    }

    @Override
    public void startGame(int roomId) throws RemoteException {
        Room r = rooms.stream().filter(
                room -> (room.getId() == roomId)
        ).findFirst().orElse(null);
        if (r != null) {
            r.initGame();
        }
    }

    @Override
    public void gameSubmit(String username, int y, int x, String v) throws RemoteException {
        Game g = getGameByUsername(username);
        if (g != null) {
            g.submit(username, y, x, v);
        }
    }

    @Override
    public void gameVote(String username, String[] words) throws RemoteException {
        Game g = getGameByUsername(username);
        if (g != null) {
            System.out.println(1);
            g.vote(username, words);
        }
    }

    @Override
    public void gameExit(int roomId) throws RemoteException {
        Game g = getGameByRoomId(roomId);
        if (g != null) {
            g.exit();
        }
    }

    private Room getRoomById(int roomId) {
        return rooms.stream().filter(
                room -> room.getId() == roomId
        ).findFirst().orElse(null);
    }

    private Room getRoomByUsername(String username) {
        return rooms.stream().filter(
                room -> room.getUsers().contains(username)
        ).findFirst().orElse(null);
    }

    private Game getGameByUsername(String username) {
        Room room = this.getRoomByUsername(username);
        if (room != null) {
            return room.getGame();
        }
        return null;
    }

    private Game getGameByRoomId(int roomId) {
        Room room = getRoomById(roomId);
        if (room != null) {
            return room.getGame();
        }
        return null;
    }
}
