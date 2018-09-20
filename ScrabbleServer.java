import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



/**
  * @author Kuan Tian
  * 2018-09-20
  */

public class ScrabbleServer {
	private ServerSocket server;
	private Socket socket;
	private static int port=55566;
	private ArrayList<ScrabblePlayer> pList= new ArrayList<ScrabblePlayer>();
	
	public ScrabbleServer(){
		try {
			server = new ServerSocket(port);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		while(true) {
			try {
				socket = server.accept();
				new ServerThread(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class ServerThread extends Thread{
		Socket soc;
		private BufferedReader br;
		private PrintWriter pw;
		
		
		//init instances for socket I/O, show the information of the client in the text panel
		public ServerThread(Socket socket) throws IOException {
			soc = socket; 
			pw = new PrintWriter(soc.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			start();
		}
		
		
		//handel the commands
		public void run() {
			String[] line;
			ScrabblePlayer a = new ScrabblePlayer("TOM");
			a.setPlayer(br, pw);

			try {
				while(true){
					line = br.readLine().split("::@:");
					if(line[0].equals("exit")){
						pw.println("");
						pw.flush();
						pw.close();
						br.close();
						break;
					}
					if(line[0].equals("Play")) {
						if(!pList.contains(a)) {
							pList.add(a);
							a.setScore(0);
						}
						pw.println("Game Start");
						pw.flush();
						System.out.println(pList.size());
						if(pList.size()>0) {
							pw.flush();
							ScrabbleGame game = new ScrabbleGame(pList);
							game.play();
							pList = new ArrayList<ScrabblePlayer>();
						}
					}
					else {
							pw.println("Error.");
							pw.flush();
						}
					}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new ScrabbleServer();
	}
}

