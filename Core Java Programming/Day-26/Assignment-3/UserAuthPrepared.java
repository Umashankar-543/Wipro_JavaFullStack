package Day_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAuthPrepared {

	private static final String URL = "jdbc:mysql://localhost:3306/wipro_test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "rps@2345";

	public static boolean authenticateUser(String userId, String password) {
		String hashedPassword = PasswordHasher.hashPassword(password);
		String sql = "SELECT * FROM User WHERE UserID = ? AND Password = ?";
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, userId);
			pstmt.setString(2, hashedPassword);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("User authenticated successfully.");
					return true;
				} else {
					System.out.println("Authentication failed.");
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the UserId to login: ");
		String userid = sc.nextLine();
		System.out.println("Enter the password to login: ");
		String password = sc.nextLine();
		authenticateUser(userid, password);
		sc.close();
	}

}