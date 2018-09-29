import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
  * 2018-09-18
  */


public class ScrabblePlayer {
	private String userName;
	private int score;
	private BufferedReader pbr;
	private PrintWriter ppw;

	public ScrabblePlayer(String userName) {
		this.userName = userName;
		this.score = 0;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setPlayer(Socket soc) {
		try {
			ppw = new PrintWriter(soc.getOutputStream(),true);
			pbr = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void SetOperation(String operation) {
		//send operation to the client
		ppw.println(operation);
		ppw.flush();
	}
	
	// 获得该回合的操作，设计为只有两种形式，"PASS"或者是坐标+字符（以\t分割），如"E 8 A"
	// 可以由GUI展现一个新窗口的方式获取信息
	public String getOperation() {
		try {
			return pbr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/** 获得是否投票的信息，可以由GUI展现一个新窗口的方式获取信息
	public boolean getVote() {
		// TODO Auto-generated method stub
		return false;
	}

	// 获取投票信息，设计为只有两种形式
	// 以"\t"切分后长度为3（类似"X E G"，"Y 5 8"），代表投票一个词（与新加字符同行或同列）
	// 或6 （类似"X E G Y 5 8"），代表同时投票两个词（其一与新加字符同行，其一同列）
	// 可以由GUI展现一个新窗口的方式获取信息
	public String getVoteMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	// 对于一个词进行投票
	public boolean vote(String userName, String word) {
		//
		return false;
	}**/

}
