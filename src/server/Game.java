package server;

import com.google.gson.Gson;
import remote.IClientAgent;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Game {

    private static UserService userService = UserService.getInstance();
    private static Gson gson = new Gson();
    private static Logger log = Logger.getLogger("Game Log");

    private int id;
    private String[][] board = new String[20][20];
    private ArrayList<GameUser> users = new ArrayList<>();
    private String activeUser;
    private GameVote vote;
    private boolean showResult = false;

    private transient ArrayList<String> usernames;
    private transient int passCounter = 0;
    private transient int wordACounter = 0;
    private transient int wordBCounter = 0;
    private transient int voterCounter = 0;


    public Game(int id, ArrayList<String> usernames) {
        this.id = id;
        this.usernames = usernames;
        usernames.forEach(username -> {
            users.add(new GameUser(username));
            userService.getUserByUsername(username).enterGame();
        });
        GameUser firstGameUser = users.get(0);
        if (firstGameUser != null) {
            activeUser = firstGameUser.name;
        }
        pushGameState();
        log.info("Game in room " + id + " has started.");
    }

    public void submit(String username, int y, int x, String letter) {
        if (!username.equals(activeUser)) {
            return;
        }
        if (letter.equals("_PASS")) {
            passCounter++;
            if (passCounter == users.size()) {
                exit();
            }
            setNextTurn();
            pushGameState();
            log.info(username + " has passed.");
            return;
        }
        board[y][x] = letter;
        passCounter = 0;
        vote = GameVote.from(board, y, x);
        pushGameState();
        log.info(username + " has submitted letter '" + letter
                + "' in position (" + x + ", " + y + ").");
    }

    private void setNextTurn() {
        setNextActiveUser();
        vote = null;
        wordACounter = 0;
        wordBCounter = 0;
        voterCounter = 0;
    }

    private void setNextActiveUser() {
        int indexOfActiveUser = usernames.indexOf(activeUser);
        indexOfActiveUser = indexOfActiveUser < usernames.size() - 1 ? indexOfActiveUser + 1 : 0;
        activeUser = usernames.get(indexOfActiveUser);
    }

    public void exit() {
        showResult = true;
        usernames.forEach(username -> {
            userService.getUserByUsername(username).leaveGame();
        });
        pushGameState();
        log.info("Game in room " + id + " is over.");
    }


    public void vote(String username, String[] words) {
        for (String word : words) {
            if (word.equals(vote.wordA)) {
                wordACounter++;
            }
            if (word.equals(vote.wordB)) {
                wordBCounter++;
            }
        }
        voterCounter++;
        int total = users.size() - 1;
        if (voterCounter >= total) {
            GameUser curUser = getGameUser(activeUser);
            int score = curUser.score;
            if (vote.wordA.length() == 1 && vote.wordB.length() == 1) {
                if (wordACounter >= total) {
                    score += vote.wordA.length();
                }
            } else {
                if (wordACounter >= total) {
                    score += vote.wordA.length();
                }
                if (wordBCounter >= total) {
                    score += vote.wordB.length();
                }
            }
            curUser.setScore(score);
            setNextTurn();
            pushGameState();
            log.info(username + " has voted.");
        }
    }

    private GameUser getGameUser(String username) {
        return users.stream().filter(gameUser ->
                gameUser.name.equals(username)
        ).findFirst().orElse(null);
    }

    private void pushGameState() {
        usernames.forEach(username -> {
            IClientAgent c = userService.getClientByUsername(username);
            if (c != null) {
                try {
                    c.updateGameState(toJson());
                } catch (Exception ignore) {
//                    log.warning(e.getMessage());
                }
            }
        });
    }

    private String toJson() {
        return gson.toJson(this);
    }


}

class GameUser {
    String name;
    int score = 0;

    public GameUser(String username) {
        this.name = username;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }
}

class GameVote {
    boolean active;
    String wordA, wordB;

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


