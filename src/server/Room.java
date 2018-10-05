package server;

import com.google.gson.Gson;
import remote.IClientAgent;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Room {

    private static UserService userService = UserService.getInstance();
    private static Gson gson = new Gson();
    private static Random random = new Random();
    private static Logger log = Logger.getLogger("Room Log");

    private int id;
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> waitingUsers = new ArrayList<>();

    private transient Game game;

    public Room(String creator) {
        this.id = random.nextInt(999999);
        this.users.add(creator);
        userService.getUserByUsername(creator).enterRoom(this.id);
        pushRoomStateUpdate();
        log.info("Room " + id + " has been created by " + creator + ".");
    }

    public void leave(String username) {
        users.remove(username);
        userService.getUserByUsername(username).leaveRoom();
        pushRoomStateUpdate();
        log.info(username + " has left room " + id + ".");
    }

    public void inviteUser(String invitor, String invitee) {
        IClientAgent client = userService.getClientByUsername(invitee);
        waitingUsers.add(invitee);
        try {
            client.updateInvitation(gson.toJson(new CIInvitation(id, invitor)));
        } catch (Exception ignored) {
        }
        pushRoomStateUpdate();
        log.info(invitor + " has invited " + invitee + ".");
    }

    public void acceptInvitation(String invitee) {
        waitingUsers.remove(invitee);
        if (!users.contains(invitee)) {
            users.add(invitee);
            userService.getUserByUsername(invitee).enterRoom(this.id);
            pushRoomStateUpdate();
            log.info(invitee + " has accepted the invitation.");
        }
    }

    public void refuseInvitation(String invitee) {
        waitingUsers.remove(invitee);
        pushRoomStateUpdate();
        log.info(invitee + " has refused the invitation.");
    }

    public void initGame() {
        game = new Game(id, users);
    }


    private void pushRoomStateUpdate() {
//        userService.getClientsByUsernames(users).forEach(client -> {
//            try {
//                client.updateRoomState(toJson());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });

        users.forEach(username -> {
            IClientAgent c = userService.getClientByUsername(username);
            if (c != null) {
                try {
                    c.updateRoomState(toJson());
                } catch (Exception e) {
                    log.warning(e.getMessage());
                    //todo: remove client
                }
            }
        });
    }

    private String toJson() {
        return gson.toJson(this);
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public Game getGame() {
        return game;
    }


    private class CIInvitation {

        int roomId;
        String invitor;

        public CIInvitation(int roomId, String invitor) {
            this.roomId = roomId;
            this.invitor = invitor;
        }
    }

}
