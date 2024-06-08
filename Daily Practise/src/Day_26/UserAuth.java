package Day_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserAuth {
	private static final String URL = "jdbc:mysql://localhost:3306/wipro_test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "rps@2345";

	public static void insertUser(String userId, String password) {
		String hashedPassword = PasswordHasher.hashPassword(password);
		String sql = "INSERT INTO User (UserID, Password) VALUES ('" + userId + "', '" + hashedPassword + "')";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("User inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean authenticateUser(String userId, String password) {
		String hashedPassword = PasswordHasher.hashPassword(password);
		String sql = "SELECT * FROM User WHERE UserID = '" + userId + "' AND Password = '" + hashedPassword + "'";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.next()) {
				System.out.println("User authenticated successfully.");
				return true;
			} else {
				System.out.println("Authentication failed.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the UserId to register: ");
		String uid = sc.nextLine();
		System.out.println("Enter the password to register: ");
		String pass = sc.nextLine();

		insertUser(uid, pass);

		System.out.println("Enter the UserId to login: ");
		String userid = sc.nextLine();
		System.out.println("Enter the password to login: ");
		String password = sc.nextLine();

		authenticateUser(userid, password);
		sc.close();
	}
}