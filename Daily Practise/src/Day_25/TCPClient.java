package Day_25;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		String hostname = "localhost";
		int port = 12345;
		try (Socket socket = new Socket(hostname, port);
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
			Operation operation = new Operation(2, 2, "+");
			oos.writeObject(operation);
			int result = (int) ois.readObject();
			System.out.println("Result: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}