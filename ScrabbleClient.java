import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


/**
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
		
		public String listen() {
			String a = null;
			while(true) {
				try {
					a = mebr.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(a!=null) break;
			}
			return a;
		}

		// send the command to the server and get reply
		public String operate(String word) {
			String line;
			String message;

			try {

				while (true) {
					line = word;
					if (line != null && line.length() > 0) {
						pw.println(line);
						pw.flush();

					}
					if ((message = mebr.readLine()) != null) {
						return message;
					}
					break;
				}
			} catch (SocketException e) {
				System.out.println("Error: The host is unreachable!");
				System.exit(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			terminate();
			return null;

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
	}


