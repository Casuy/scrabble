package scrabble;

// �����Ӧ�������ڷ�������������ͻ���ͨ��RMI��ʽ��ȡ����
public class ScrabblePlayer {
	private String userName;
	private int score;
	private char[][] scrabbleGrid;
	
	public ScrabblePlayer(String userName) {
		this.userName = userName;
		this.score = 0;
	}
	public String getUserName() {
		return userName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setScrabbleGrid(char[][] scrabbleGrid) {
		this.scrabbleGrid = scrabbleGrid;
	}
	
	// չʾ���̣���GUIʵ��
	public void printGrid () {
		
	}
	
	// ��øûغϵĲ��������Ϊֻ��������ʽ��"PASS"����������+�ַ�����\t�ָ����"E	8	A"
	// ������GUIչ��һ���´��ڵķ�ʽ��ȡ��Ϣ
	public String getOperation() {
		return null;
	}
	// ����Ƿ�ͶƱ����Ϣ��������GUIչ��һ���´��ڵķ�ʽ��ȡ��Ϣ
	public boolean getVote() {
		// TODO Auto-generated method stub
		return false;
	}
	// ��ȡͶƱ��Ϣ�����Ϊֻ��������ʽ
	// ��"\t"�зֺ󳤶�Ϊ3������"X	E	G"��"Y	5	8"��������ͶƱһ���ʣ����¼��ַ�ͬ�л�ͬ�У�
	// ��6 ������"X	E	G	Y	5	8"��������ͬʱͶƱ�����ʣ���һ���¼��ַ�ͬ�У���һͬ�У�
	// ������GUIչ��һ���´��ڵķ�ʽ��ȡ��Ϣ
	public String getVoteMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ����һ���ʽ���ͶƱ
	public boolean vote (String userName ,String word) {
		//
		return false;
	}
	
}
