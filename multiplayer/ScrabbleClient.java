import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
  * @author Kuan Tian
  * 2018-09-20
  */

public class ScrabbleClient {
	public static String ServerAd = "localhost";
	public static int port = 55566;

		private Socket socket;
		private BufferedReader mebr;
		private PrintWriter pw;

		// Instantiate the socket with the address and port
		public ScrabbleClient() {
			try {
				socket = new Socket(ServerAd, port);
				pw = new PrintWriter(socket.getOutputStream());
				mebr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				new Thread(new Read()).start();
			} catch (SocketException e) {
				System.out.println("Error: The host is unreachable!");
				System.exit(0);
			} catch (UnknownHostException e) {
				System.out.println("Error: Unknown host!");
				System.exit(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		// send the command to the server and get reply
		public void operate(String word) {
			String line;

			while (true) {
				line = word;
				if (line != null && line.length() > 0) {
					pw.println(line);
					pw.flush();

				}
				break;
			}


		}

		// close the socket
		public void terminate() {
			try {
				pw.close();
				mebr.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		class Read implements Runnable{
			String message =null;
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						message= mebr.readLine();
						if(message!=null) ScrabblePanel.showMessage(message);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
					
				}
			}
			
		}
		
	}


