package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataExample {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/wipro_test";
		String username = "root";
		String password = "rps@2345";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			String sql = "SELECT * FROM user";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsMetaData = resultSet.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			System.out.println("Number of Columns: " + columnCount);
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsMetaData.getColumnName(i);
				String columnTypeName = rsMetaData.getColumnTypeName(i);
				int columnDisplaySize = rsMetaData.getColumnDisplaySize(i);
				boolean isNullable = rsMetaData.isNullable(i) == ResultSetMetaData.columnNullable;
				System.out.println("Column " + i + ": " + columnName);
				System.out.println(" - Type: " + columnTypeName);
				System.out.println(" - Display Size: " + columnDisplaySize);
				System.out.println(" - Nullable: " + isNullable);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}