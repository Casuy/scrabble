package server;

import com.google.gson.Gson;
import remote.IClientAgent;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    private static Gson gson = new Gson();
    private static Random rnd = new Random();

    private static UserService userService = UserService.getInstance();
    private static LoginService loginService = LoginService.getInstance();

    private int id;
    private ArrayList<String> users = new ArrayList<>();
    private ArrayList<String> waitingUsers = new ArrayList<>();
    private transient Game game;


    public Room(String creator) {
        this.id = rnd.nextInt(999999);
        this.users.add(creator);
        pushRoomStateUpdate();
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

//    public ArrayList<String> getUsernames() {
//        ArrayList<String> usernames = new ArrayList<>();
//        for (User user : users) {
//            usernames.add(user.getUsername());
//        }
//        return usernames;
//    }
//
//    public void addUser(String username) {
//        users.add(userService.getUser(username));
//        String json = toJson();
//
//        try {
//            for (IClientAgent client : loginService.getClientsByUsers(users)) {
//                client.updateRoomState(json);
//            }
//        } catch (Exception ignored) {
//
//        }
//    }

    void initGame() {
        this.game = new Game(this.id, users);
    }

    public Game getGame() {
        return game;
    }


    void inviteUser(String invitor, String invitee) {
        IClientAgent c = loginService.getClientByUsername(invitee);
        waitingUsers.add(invitee);
        try {
            c.updateInvitation(gson.toJson(new CIInvitation(id, invitor)));
        } catch (Exception ignored) {

        }
        pushRoomStateUpdate();
    }

    void acceptInvitation(String invitee) {
        waitingUsers.remove(invitee);
        if (!users.contains(invitee)) {
            users.add(invitee);
            pushRoomStateUpdate();
        }
    }

    void refuseInvitation(String invitee) {
        waitingUsers.remove(invitee);
        pushRoomStateUpdate();
    }

    void leave(String username) {
        users.remove(username);
        pushRoomStateUpdate();
    }

    void pushRoomStateUpdate() {
        try {
            for (IClientAgent client : loginService.getClientsByUsernames(users)) {
                client.updateRoomState(toJson());
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
    }


    private String toJson() {
//        CIRoom r = new CIRoom();
//        r.id = id;
//        r.users = getUsernames();
//        return gson.toJson(r);
        return gson.toJson(this);
    }
}

class CIInvitation {
    int roomId;
    String invitor;

    CIInvitation(int roomId, String invitor) {
        this.roomId = roomId;
        this.invitor = invitor;
    }

}