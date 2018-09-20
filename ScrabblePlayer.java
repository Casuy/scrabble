import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
  * 2018-09-18
  */


public class ScrabblePlayer {
	private String userName;
	private int score;
	private BufferedReader br;
	private PrintWriter pw;

	public ScrabblePlayer(String userName) {
		this.userName = userName;
		this.score = 0;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setPlayer(BufferedReader b, PrintWriter p) {
		br=b;
		pw=p;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void SetOperation(String operation) {
		//send operation to the client
		pw.println(operation);
		pw.flush();
	}
	
	// ��øûغϵĲ��������Ϊֻ��������ʽ��"PASS"����������+�ַ�����\t�ָ����"E 8 A"
	// ������GUIչ��һ���´��ڵķ�ʽ��ȡ��Ϣ
	public String getOperation() {
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** ����Ƿ�ͶƱ����Ϣ��������GUIչ��һ���´��ڵķ�ʽ��ȡ��Ϣ
	public boolean getVote() {
		// TODO Auto-generated method stub
		return false;
	}

	// ��ȡͶƱ��Ϣ�����Ϊֻ��������ʽ
	// ��"\t"�зֺ󳤶�Ϊ3������"X E G"��"Y 5 8"��������ͶƱһ���ʣ����¼��ַ�ͬ�л�ͬ�У�
	// ��6 ������"X E G Y 5 8"��������ͬʱͶƱ�����ʣ���һ���¼��ַ�ͬ�У���һͬ�У�
	// ������GUIչ��һ���´��ڵķ�ʽ��ȡ��Ϣ
	public String getVoteMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	// ����һ���ʽ���ͶƱ
	public boolean vote(String userName, String word) {
		//
		return false;
	}**/

}
