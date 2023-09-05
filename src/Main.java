import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) {
		try {
			
			ServerSocket serverSocket = new ServerSocket(3000);
			Socket clientSocket = serverSocket.accept();
			OutputStream outputStream = clientSocket.getOutputStream();
			PrintWriter outputWriter = new PrintWriter(outputStream);
			
			outputWriter.println("HTTP/1.1 200 OK");
			outputWriter.println("Content-Type: text/html");
			outputWriter.println("");
			outputWriter.println("<p>Hello, world!</p>");
			outputWriter.flush();
			
			Thread.sleep(10000);
			
			clientSocket.close();
			serverSocket.close();
			
		} catch (IOException | InterruptedException exception) {
			System.out.printf("Error while running server: %s%n", exception);
		}
	}
	
}
