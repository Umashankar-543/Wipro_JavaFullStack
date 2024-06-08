package Day_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserTable {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/wipro_test";

		String username = "root";

		String password = "rps@2345";

		try (Connection conn = DriverManager.getConnection(url, username, password);

				Statement stmt = conn.createStatement()) {

			String sql = "CREATE TABLE IF NOT EXISTS User (" +

					"UserID VARCHAR(255) PRIMARY KEY, " +

					"Password VARCHAR(255) NOT NULL)";

			stmt.executeUpdate(sql);

			System.out.println("Table 'User' created successfully.");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}