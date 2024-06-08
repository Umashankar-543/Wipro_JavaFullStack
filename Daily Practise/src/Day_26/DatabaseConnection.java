package Day_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/wipro_test";
		String username = "root";
		String password = "rps@2345";
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established: " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}