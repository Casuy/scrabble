package server;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static Gson gson = new Gson();
    private static LoginService loginService = LoginService.getInstance();
    private ArrayList<GameUser> users = new ArrayList<>();
    private transient ArrayList<String> usernames;
    private String[][] board = new String[20][20];
    String activeUser;
    GameVote vote;
    private transient int passCounter = 0;
    private transient int voteACounter = 0;
    private transient int voteBCounter = 0;
    private transient int voterCounter = 0;


    private int id;

    public Game(int id, ArrayList<String> usernames) {
        this.id = id;
        for (String username : usernames) {
            GameUser gu = new GameUser();
            gu.name = username;
            this.users.add(gu);
        }
        this.usernames = usernames;
        GameUser firstGameUser = this.users.get(0);
        if (firstGameUser != null) {
            activeUser = firstGameUser.name;
        }
        pushGameState();
    }

    void submit(String username, int y, int x, String v) {
        if (!username.equals(activeUser)) {
            return;
        }
        if (v.equals("_PASS")) {
            passCounter++;
            if (passCounter == users.size()) {
                // todo: game exit
                System.out.println("todo: game exit");
            }
            setNextTurn();
            pushGameState();
            return;
        }
        board[y][x] = v;
        passCounter = 0;
        vote = GameVote.from(board, y, x);
        pushGameState();
    }

    void vote(String username, String[] words) {

        for (String word : words) {
            if (word.equals(vote.wordA)) {
                voteACounter++;
            }
            if (word.equals(vote.wordB)) {
                voteBCounter++;

            }
        }
        voterCounter++;
        int total = users.size() - 1;
        System.out.println(total);
        System.out.println(voterCounter);
        if (voterCounter >= total) {
            GameUser activeU = getGameUser(activeUser);
            int score = activeU.score;
            if (voteACounter >= total) {
                score += vote.wordA.length();
            }
            if (voteBCounter >= total) {
                score += vote.wordB.length();
            }
            activeU.setScore(score);
            setNextTurn();
            pushGameState();
        }
    }

    public GameUser getGameUser(String name) {
        for (GameUser gu : users) {
            if (gu.name.equals(name)) {
                return gu;
            }
        }
        return null;
    }

    void setNextActiveUser() {
        int indexOfActiveUser = usernames.indexOf(activeUser);
        indexOfActiveUser = indexOfActiveUser < usernames.size() - 1 ? indexOfActiveUser + 1 : 0;
        activeUser = usernames.get(indexOfActiveUser);
    }

    void setNextTurn() {
        setNextActiveUser();
        vote = null;
        voteACounter = 0;
        voteBCounter = 0;
        voterCounter = 0;
    }

    String toJson() {
        return gson.toJson(this);
    }

    void pushGameState() {
        loginService.getClientsByUsernames(usernames).forEach(c -> {
            try {
                c.updateGameState(toJson());
            } catch (Exception ignored) {
            }
        });
    }

}

class GameUser {
    String name;
    int score;

    public void setScore(int newScore) {
        this.score = newScore;
    }

}

class GameVote {
    boolean active;
    String wordA;
    String wordB;

    static GameVote from(String[][] board, int y, int x) {
        GameVote vote = new GameVote();
        vote.active = true;
        for (int i = 0; i < board.length; i++) {
            if (i == y) {
                for (int j = 0; j < board[i].length; j++) {
                    String cur = board[i][j];
                    if (j <= x) {
                        if (cur != null) {
                            vote.wordA += cur;
                        } else {
                            vote.wordA = "";
                        }
                    } else {
                        if (cur != null) {
                            vote.wordA += cur;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == x) {
                    String cur = board[i][j];
                    if (i <= y) {
                        if (cur != null) {
                            vote.wordB += cur;
                        } else {
                            vote.wordB = "";
                        }
                    } else {
                        if (cur != null) {
                            vote.wordB += cur;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return vote;
    }
}
