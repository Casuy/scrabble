package scrabble;

import java.util.ArrayList;

public class ScrabbleGame {
	private char[][] scrabbleGrid;
	private ScrabblePlayer[] playerList;
	private int playerNumber;
	
	// 接受ScrabblePlayer类的ArrayList作为参数，初始化游戏
	public ScrabbleGame(ArrayList<ScrabblePlayer> playerList) {
		scrabbleGrid = new char[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				scrabbleGrid[i][j] = ' ';
			}
		}		
		playerNumber = playerList.size();
		this.playerList = new ScrabblePlayer[playerNumber];
		for (int i = 0; i < playerNumber; i++) {
			this.playerList[i] = playerList.get(i);
			this.playerList[i].setScrabbleGrid(scrabbleGrid);
		}
	}
	
	// 将棋盘某个位置的符号设置为指定符号并发送给所有玩家（实际过程中应该由socket解决发送问题）
	public void setChar (int x, int y, char a) {
		scrabbleGrid[x][y] = a;
		for (int i = 0; i < playerNumber; i++) {
			playerList[i].setScrabbleGrid(scrabbleGrid);
			playerList[i].printGrid();
		}
	}
	
	// 根据坐标获得一个String，坐标中的横纵坐标至少有一组是相同的（由游戏过程保证）
	public String word (int x1, int y1, int x2, int y2) {
		int wordLength = Math.max(x2 - x1, y2 - y1);
		char[] wordChar = new char[wordLength];
		if (x1 - x2 == 0) {
			for (int i = y1; i < y2; i++) {
				wordChar[i] = scrabbleGrid[x1][i];
			}
		} else {
			for (int i = x1; i < x2; i++) {
				wordChar[i] = scrabbleGrid[i][y1];
			}
		}
		String word = (new String(wordChar)).trim();
		return word;
	}
	
	// 让当前玩家外的其他玩家对一个词投票，一致通过则返回true，出错视为不通过
	public boolean vote(int current, String word) {
		int voteNumber = 1;
		for (int i = (current + 1) % playerNumber; i != current; i = (i + 1) % playerNumber ) {
			boolean voted = false;
			try {
				voted = playerList[i].vote(playerList[current].getUserName(), word);
			} catch (Exception e) {
				
			}
			if (voted)	voteNumber++;
		}
		if (voteNumber == playerNumber) {
			return true;
		}
		return false;
	}
	
	// 使某个玩家得分
	public void gainScore (int player, String word) {
		playerList[player].setScore(word.length() + playerList[player].getScore());
	}
	
	public void play() {
		int passPlayers = 0;
		int current = 0;
		while (passPlayers < playerNumber) {
			
			// 新一轮，重计弃权玩家
			if (current == 0) {
				passPlayers = 0;
			}
			String operation = "PASS";
			// 从GUI中读取玩家的操作，以String传递给服务器，如果出错视为pass
			try {
				operation = playerList[current].getOperation();
			} catch (Exception e) {
				
			}
			// 操作的String设计为只有两种形式，"PASS"或者是坐标+字符（以\t分割），如"E	8	A"
			if (operation.equals("PASS")) {
				passPlayers += 1;
			}
			else {
				String[] operations = operation.split("\t");
				
				// 从operations中读取坐标和字符。注意如坐标E8代表第5列第8行，反映到数组上应该是[7][4]
				int x = Integer.parseInt(operations[1]) - 1;
				int y = operations[0].toUpperCase().toCharArray()[0] - 'A';
				char a = operations[2].toUpperCase().toCharArray()[0];
				setChar(x, y, a);
				
				// 玩家执行操作之后询问是否投票，出错视作放弃投票
				boolean vote = false;
				try {
					vote = playerList[current].getVote();
				} catch (Exception e) {
					
				}
				if (vote) {
					
					// 投票信息，设计为只有两种形式
					// 以"\t"切分后长度为3（类似"X	E	G"，"Y	5	8"），代表投票一个词（与新加字符同行或同列）
					// 或6 （类似"X	E	G	Y	5	8"），代表同时投票两个词（其一与新加字符同行，其一同列）
					String voteMessage = playerList[current].getVoteMessage();
					String[] message = voteMessage.split("\t");
					if (message.length > 3) {
						int y1 = message[1].toUpperCase().toCharArray()[0] - 'A';
						int y2 = message[2].toUpperCase().toCharArray()[0] - 'A';
						String voteWord = word(x, x, y1, y2);
						boolean allVote = vote(current, voteWord);
						if (allVote) {
							gainScore(current, voteWord);
						}
						int x1 = Integer.parseInt(message[4]) - 1;
						int x2 = Integer.parseInt(message[5]) - 1;
						voteWord = word(x1, x2, y, y);
						allVote = vote(current, voteWord);
						if (allVote) {
							gainScore(current, voteWord);
						}
					} else {
						if (message[0].equals("X")) {
							int x1 = message[1].toUpperCase().toCharArray()[0] - 'A';
							int x2 = message[2].toUpperCase().toCharArray()[0] - 'A';
							String voteWord = word(x1, x2, y, y);
							boolean allVote = vote(current, voteWord);
							if (allVote) {
								gainScore(current, voteWord);
							}
						} else {
							int y1 = Integer.parseInt(message[1]) - 1;
							int y2 = Integer.parseInt(message[2]) - 1;
							String voteWord = word(x, x, y1, y2);
							boolean allVote = vote(current, voteWord);
							if (allVote) {
								gainScore(current, voteWord);
							}
						}
					}
				}
			}
			current = (current + 1) % playerNumber;
		}
	}
}
