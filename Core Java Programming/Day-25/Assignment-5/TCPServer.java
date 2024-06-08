package Day_25;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(12345)) {
			System.out.println("Server is listening on port 12345");
			while (true) {
				try (Socket socket = serverSocket.accept();
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
					Operation operation = (Operation) ois.readObject();
					int result = 0;
					switch (operation.operator) {
					case "+":
						result = operation.num1 + operation.num2;
						break;
					case "-":
						result = operation.num1 - operation.num2;
						break;
					case "*":
						result = operation.num1 * operation.num2;
						break;
					case "/":
						if (operation.num2 != 0) {
							result = operation.num1 / operation.num2;
						} else {
							result = Integer.MAX_VALUE;
						}
						break;
					default:
						result = 0;
						break;
					}
					oos.writeObject(result);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}