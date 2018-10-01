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
        log.info("User '"+name+"' has logged out.");
    }

    public void enterRoom() {
        this.inRoom = true;
        pushUserListUpdate();
    }

    public void leaveRoom() {
        this.inRoom = false;
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
        userService.getAllClients().forEach(
                client -> {
                    try {
                        client.updateUserList(toJson());
                    } catch (Exception ignored) {
                    }
                }
        );
    }

    private String toJson() {
        return gson.toJson(userService.getUsers());
    }

    public String getName() {
        return name;
    }

    public Boolean getInRoomState() {
        return inRoom;
    }

}
