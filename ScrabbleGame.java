import java.util.ArrayList;

public class ScrabbleGame {
	private char[][] scrabbleGrid;
	private ScrabblePlayer[] playerList;
	private int playerNumber;
	private int passPlayers;
	private int current;
	private int votenumber = 0;

	// init the game
	public ScrabbleGame(ArrayList<ScrabblePlayer> pList) {
		scrabbleGrid = new char[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				scrabbleGrid[i][j] = ' ';
			}
		}
		playerNumber = pList.size();
		playerList = new ScrabblePlayer[playerNumber];
		for (int i = 0; i < playerNumber; i++) {
			playerList[i] = pList.get(i);
		}
		current = 0;
		passPlayers = 0;
	}

	// get the word from the coordinate
	public String word(int x1, int y1, int x2, int y2) {
		int wordLength = Math.max(x2 - x1 + 1, y2 - y1 + 1);
		String word = null;
		if(x1==x2 && y1==y2) {
			word = String.valueOf(scrabbleGrid[x1][y1]);
			return word;
		}
		char[] wordChar = new char[wordLength];
		if (x1 - x2 == 0) {
			for (int i = y1; i <= y2; i++) {
				wordChar[i] = scrabbleGrid[x1][i];
			}
		} else {
			for (int i = x1; i <= x2; i++) {
				wordChar[i] = scrabbleGrid[i][y1];
			}
		}
		word = (new String(wordChar)).trim();
		return word;
	}

	// broadcast the message to all the players
	public void broadcast(String operation) {
		for (int i = 0; i < playerNumber; i++) {
			playerList[i].SetOperation(operation);
		}
	}


	// player get score
	public void gainScore(int player, String word) {
		playerList[player].setScore(word.length() + playerList[player].getScore());
	}

	public void play() {
		broadcast("Game Start");
		String voteWord = null;
		while (passPlayers < playerNumber) {
			// new turn
			if (current == 0) {
				passPlayers = 0;
			}
			String operation = null;
			// get player's operation
			try {
				while (true) {
					operation = playerList[current].getOperation();
					if (operation != null)
						break;
				}
			} catch (Exception e) {

			}
			System.out.println(operation);
			String[] operations = operation.split("::@:");
			if (operations[0].equals("Pass")) {
				passPlayers += 1;
			}
			//if the operation is set, broadcast the letter been inserted
			else if (operations[0].equals("Set")) {
				String[] setword = operations[1].split(" ");
				int x = Integer.parseInt(setword[1]) - 1;
				int y = setword[0].toUpperCase().toCharArray()[0] - 'A';
				char a = setword[2].toUpperCase().toCharArray()[0];
				scrabbleGrid[x][y] = a;
				for(int i=0;i<20;i++) {
					for(int j=0;j<20;j++) {
						System.out.println(scrabbleGrid[i][j]+" ");
					}
					System.out.println();
				}
				broadcast(operation);
			}
			//create a vote
			else if (operations[0].equals("Vote")) {
				String voteMessage = operations[1];
				String[] message = voteMessage.split(" ");
				int y1 = message[0].toUpperCase().toCharArray()[0] - 'A';
				int y2 = message[1].toUpperCase().toCharArray()[0] - 'A';
				int x1 = Integer.parseInt(message[2]) - 1;
				int x2 = Integer.parseInt(message[3]) - 1;
				voteWord = word(x1, y1, x2, y2);
				String m = "Vote::@:" + playerList[current].getUserName() + "::@:" + voteWord;
				broadcast(m);

			}
			//vote for a word
			else if (operations[0].equals("VoteYes")) {
				votenumber += 1;
				if (votenumber == playerNumber) gainScore(current, voteWord);
				broadcast("The vote now is"+votenumber);
			}

			current = current < playerNumber - 1 ? current + 1 : 0;
		}
		int maxscore = 0;
		String winner = "";
		for (int i = 0; i < playerNumber; i++) {
			if (playerList[i].getScore() > maxscore) {
				maxscore = playerList[i].getScore();
				winner = playerList[i].getUserName();
			}
		}
		// broadcast the winner and the score when a game ends
		broadcast("GameOver::@:" + winner + "::@:" + maxscore);

	}
}
