/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.27
 *
 * @author Silberschatz, Gagne, and Galvin. 
 * Operating System Concepts  - Tenth Edition
 * Copyright John Wiley & Sons - 2018.
 */
 
import java.io.*;
import java.net.*;

public class DateServer
{
	public static void main(String[] args)  {
		try {
			ServerSocket sock = new ServerSocket(6013);

			// now listen for connections
			while (true) {
				System.out.println("Listening...");
				Socket client = sock.accept();
				// we have a connection
				System.out.println("New client connected!");
				
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
				// write the Date to the socket
				pout.println(new java.util.Date().toString());
				pout.println("Hello new client, how can I help you?");

				// close the socket and resume listening for more connections
				client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
