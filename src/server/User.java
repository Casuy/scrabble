package server;

public class User {

    private GameService gameService = GameService.getInstance();
    private String username;
    private int score;

    public User() {
        super();
    }

    public User(String username) {
        this.username = username;
        this.score = 0;
    }

    public String getUsername() {
        return this.username;
    }

    public int getScore() {
        return this.score;
    }
}
