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
	
	// set i/o for the player 
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
	
	// get operation from each client
	public String getOperation() {
		try {
			return pbr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
