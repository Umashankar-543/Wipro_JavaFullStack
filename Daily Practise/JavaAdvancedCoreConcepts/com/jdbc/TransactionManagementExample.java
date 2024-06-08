package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManagementExample {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/wipro_test";
		String username = "root";
		String password = "rps@2345";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
			performDatabaseOperations(connection);
			connection.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException rollbackEx) {
				rollbackEx.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.setAutoCommit(true);
					connection.close();
				}

			} catch (SQLException closeEx) {
				closeEx.printStackTrace();
			}
		}
	}

	private static void performDatabaseOperations(Connection connection) throws SQLException {
		String insertUserSql = "INSERT INTO user (username, email) VALUES (?, ?)";
		String updateUserSql = "UPDATE user SET email = ? WHERE username = ?";
		try (PreparedStatement insertUserStmt = connection.prepareStatement(insertUserSql);
				PreparedStatement updateUserStmt = connection.prepareStatement(updateUserSql)) {
			insertUserStmt.setString(1, "Umashankar");
			insertUserStmt.setString(2, "umashankar@example.com");
			insertUserStmt.executeUpdate();
			updateUserStmt.setString(1, "umashankarreddy@example.com");
			updateUserStmt.setString(2, "Umashankar");
			updateUserStmt.executeUpdate();
		}
	}

}