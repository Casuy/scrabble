package scrabble;

import java.util.ArrayList;

public class ScrabbleGame {
	private char[][] scrabbleGrid;
	private ScrabblePlayer[] playerList;
	private int playerNumber;
	
	// ����ScrabblePlayer���ArrayList��Ϊ��������ʼ����Ϸ
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
	
	// ������ĳ��λ�õķ�������Ϊָ�����Ų����͸�������ң�ʵ�ʹ�����Ӧ����socket����������⣩
	public void setChar (int x, int y, char a) {
		scrabbleGrid[x][y] = a;
		for (int i = 0; i < playerNumber; i++) {
			playerList[i].setScrabbleGrid(scrabbleGrid);
			playerList[i].printGrid();
		}
	}
	
	// ����������һ��String�������еĺ�������������һ������ͬ�ģ�����Ϸ���̱�֤��
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
	
	// �õ�ǰ������������Ҷ�һ����ͶƱ��һ��ͨ���򷵻�true��������Ϊ��ͨ��
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
	
	// ʹĳ����ҵ÷�
	public void gainScore (int player, String word) {
		playerList[player].setScore(word.length() + playerList[player].getScore());
	}
	
	public void play() {
		int passPlayers = 0;
		int current = 0;
		while (passPlayers < playerNumber) {
			
			// ��һ�֣��ؼ���Ȩ���
			if (current == 0) {
				passPlayers = 0;
			}
			String operation = "PASS";
			// ��GUI�ж�ȡ��ҵĲ�������String���ݸ������������������Ϊpass
			try {
				operation = playerList[current].getOperation();
			} catch (Exception e) {
				
			}
			// ������String���Ϊֻ��������ʽ��"PASS"����������+�ַ�����\t�ָ����"E	8	A"
			if (operation.equals("PASS")) {
				passPlayers += 1;
			}
			else {
				String[] operations = operation.split("\t");
				
				// ��operations�ж�ȡ������ַ���ע��������E8�����5�е�8�У���ӳ��������Ӧ����[7][4]
				int x = Integer.parseInt(operations[1]) - 1;
				int y = operations[0].toUpperCase().toCharArray()[0] - 'A';
				char a = operations[2].toUpperCase().toCharArray()[0];
				setChar(x, y, a);
				
				// ���ִ�в���֮��ѯ���Ƿ�ͶƱ��������������ͶƱ
				boolean vote = false;
				try {
					vote = playerList[current].getVote();
				} catch (Exception e) {
					
				}
				if (vote) {
					
					// ͶƱ��Ϣ�����Ϊֻ��������ʽ
					// ��"\t"�зֺ󳤶�Ϊ3������"X	E	G"��"Y	5	8"��������ͶƱһ���ʣ����¼��ַ�ͬ�л�ͬ�У�
					// ��6 ������"X	E	G	Y	5	8"��������ͬʱͶƱ�����ʣ���һ���¼��ַ�ͬ�У���һͬ�У�
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
