package server;

import com.google.gson.Gson;

import java.util.logging.Logger;

public class User {

    private static UserService userService = UserService.getInstance();
    private static Gson gson = new Gson();
    private static Logger log = Logger.getLogger("User Log");

    private String name;
    private boolean inRoom = false;
    private boolean inGame = false;

    private transient int roomId = 0;


    public User(String username) {
        this.name = username;
    }

    public void login() {
        userService.getUsers().add(this);
        pushUserListUpdate();
        log.info("User '" + name + "' has been added.");
    }

    public void logout() {
        userService.getUsers().remove(this);
        pushUserListUpdate();
        log.info("User '" + name + "' has logged out.");
    }

    public void enterRoom(int id) {
        this.inRoom = true;
        this.roomId = id;
        pushUserListUpdate();
    }

    public void leaveRoom() {
        this.inRoom = false;
        this.roomId = 0;
        pushUserListUpdate();
    }

    public void enterGame() {
        this.inGame = true;
        pushUserListUpdate();
    }

    public void leaveGame() {
        this.inGame = false;
        pushUserListUpdate();
    }

    private void pushUserListUpdate() {
        userService.getAllClients().forEach(client -> {
            try {
                client.updateUserList(toJson());
            } catch (Exception ignore) {
//                log.warning(e.getMessage());
            }
        });
    }

    private String toJson() {
        return gson.toJson(userService.getUsers());
    }

    public String getName() {
        return name;
    }

    public int getRoomId() {
        return roomId;
    }

    public Boolean getInRoomState() {
        return inRoom;
    }

    public Boolean getInGameState() {
        return inGame;
    }

}
