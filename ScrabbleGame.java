
/**
  * 2018-09-18
  */


import java.util.ArrayList;

public class ScrabbleGame {
	private char[][] scrabbleGrid;
	private ScrabblePlayer[] playerList;
	private int playerNumber;
	private int passPlayers;
	private int current;

	// ����ScrabblePlayer���ArrayList��Ϊ��������ʼ����Ϸ
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

	// ����������һ��String�������еĺ�������������һ������ͬ�ģ�����Ϸ���̱�֤��
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

	// �㲥��Ϣ
	public void broadcast(String operation) {
		for (int i = 0; i < playerNumber; i++) {
			playerList[i].SetOperation(operation);
		}
	}

	/**
	 * �õ�ǰ������������Ҷ�һ����ͶƱ��һ��ͨ���򷵻�true��������Ϊ��ͨ�� public boolean vote(int current, String
	 * word) { int voteNumber = 1; for (int i = (current + 1) % playerNumber; i !=
	 * current; i = (i + 1) % playerNumber) { boolean voted = false; try { voted =
	 * playerList[i].vote(playerList[current].getUserName(), word); } catch
	 * (Exception e) {
	 * 
	 * } if (voted) voteNumber++; } if (voteNumber == playerNumber) { return true; }
	 * return false; }
	 **/

	// ʹĳ����ҵ÷�
	public void gainScore(int player, String word) {
		playerList[player].setScore(word.length() + playerList[player].getScore());
	}

	public void play() {
		int votenumber = 0;
		String voteWord = null;
		while (passPlayers < playerNumber) {
			// ��һ�֣��ؼ���Ȩ���
			if (current == 0) {
				passPlayers = 0;
			}
			String operation = null;
			// ��GUI�ж�ȡ��ҵĲ�������String���ݸ������������������Ϊpass
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
			// ������String���Ϊֻ��������ʽ��"PASS"����������+�ַ�����\t�ָ����"E 8 A"
			if (operations[0].equals("Pass")) {
				passPlayers += 1;
			} else if (operations[0].equals("Set")) {
				String[] setword = operations[1].split(" ");
				int x = Integer.parseInt(setword[1]) - 1;
				int y = setword[0].toUpperCase().toCharArray()[0] - 'A';
				char a = setword[2].toUpperCase().toCharArray()[0];
				scrabbleGrid[x][y] = a;
				broadcast(operation);
			} else if (operations[0].equals("Vote")) {
				String voteMessage = operations[1];
				String[] message = voteMessage.split(" ");
				int y1 = message[0].toUpperCase().toCharArray()[0] - 'A';
				int y2 = message[1].toUpperCase().toCharArray()[0] - 'A';
				int x1 = Integer.parseInt(message[2]) - 1;
				int x2 = Integer.parseInt(message[3]) - 1;
				voteWord = word(x1, y1, x2, y2);
				String m = "Vote::@:" + playerList[current].getUserName() + "::@:" + voteWord;
				broadcast(m);

			} else if (operations[0].equals("VoteYes")) {
				votenumber += 1;
				if (votenumber == playerNumber) gainScore(current, voteWord);
				broadcast("The voting now is"+votenumber);
			}

			/**
			 * ���ִ�в���֮��ѯ���Ƿ�ͶƱ��������������ͶƱ boolean vote = false; try { vote =
			 * playerList[current].getVote(); } catch (Exception e) {
			 * 
			 * } if (vote) {
			 * 
			 * // ͶƱ��Ϣ�����Ϊֻ��������ʽ // ��"\t"�зֺ󳤶�Ϊ3������"X E G"��"Y 5 8"��������ͶƱһ���ʣ����¼��ַ�ͬ�л�ͬ�У� //
			 * ��6 ������"X E G Y 5 8"��������ͬʱͶƱ�����ʣ���һ���¼��ַ�ͬ�У���һͬ�У� String voteMessage =
			 * playerList[current].getVoteMessage(); String[] message =
			 * voteMessage.split("\t"); if (message.length > 3) { int y1 =
			 * message[1].toUpperCase().toCharArray()[0] - 'A'; int y2 =
			 * message[2].toUpperCase().toCharArray()[0] - 'A'; String voteWord = word(x, x,
			 * y1, y2); boolean allVote = vote(current, voteWord); if (allVote) {
			 * gainScore(current, voteWord); } int x1 = Integer.parseInt(message[4]) - 1;
			 * int x2 = Integer.parseInt(message[5]) - 1; voteWord = word(x1, x2, y, y);
			 * allVote = vote(current, voteWord); if (allVote) { gainScore(current,
			 * voteWord); } } else { if (message[0].equals("X")) { int x1 =
			 * message[1].toUpperCase().toCharArray()[0] - 'A'; int x2 =
			 * message[2].toUpperCase().toCharArray()[0] - 'A'; String voteWord = word(x1,
			 * x2, y, y); boolean allVote = vote(current, voteWord); if (allVote) {
			 * gainScore(current, voteWord); } } else { int y1 =
			 * Integer.parseInt(message[1]) - 1; int y2 = Integer.parseInt(message[2]) - 1;
			 * String voteWord = word(x, x, y1, y2); boolean allVote = vote(current,
			 * voteWord); if (allVote) { gainScore(current, voteWord); } } } } }
			 **/
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
		broadcast("GameOver::@:" + winner + "::@:" + maxscore);

	}
}
