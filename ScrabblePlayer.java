package scrabble;

// 这个类应该运行于服务器，但允许客户端通过RMI方式获取方法
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
	
	// 展示棋盘，由GUI实现
	public void printGrid () {
		
	}
	
	// 获得该回合的操作，设计为只有两种形式，"PASS"或者是坐标+字符（以\t分割），如"E	8	A"
	// 可以由GUI展现一个新窗口的方式获取信息
	public String getOperation() {
		return null;
	}
	// 获得是否投票的信息，可以由GUI展现一个新窗口的方式获取信息
	public boolean getVote() {
		// TODO Auto-generated method stub
		return false;
	}
	// 获取投票信息，设计为只有两种形式
	// 以"\t"切分后长度为3（类似"X	E	G"，"Y	5	8"），代表投票一个词（与新加字符同行或同列）
	// 或6 （类似"X	E	G	Y	5	8"），代表同时投票两个词（其一与新加字符同行，其一同列）
	// 可以由GUI展现一个新窗口的方式获取信息
	public String getVoteMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 对于一个词进行投票
	public boolean vote (String userName ,String word) {
		//
		return false;
	}
	
}
