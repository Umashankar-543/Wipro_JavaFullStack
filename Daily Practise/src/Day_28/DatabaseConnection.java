package Day_28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static DatabaseConnection instance;
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/wipro_test";
	private String username = "root";
	private String password = "rps@2345";

	private DatabaseConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException ex) {
			throw new SQLException(ex);
		}
	}

	public static DatabaseConnection getInstance() throws SQLException {
		if (instance == null) {
			synchronized (DatabaseConnection.class) {
				if (instance == null) {
					instance = new DatabaseConnection();
				}
			}
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		try {
			DatabaseConnection dbConnection = DatabaseConnection.getInstance();
			Connection connection = dbConnection.getConnection();
			if (connection != null) {
				System.out.println("Successfully connected to the database!");
				connection.close();
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}