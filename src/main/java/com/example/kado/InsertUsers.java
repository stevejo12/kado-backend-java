package com.example.kado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsers {
	private final String url = "jdbc:postgresql://localhost:5432/kado";
	private final String user = "postgres";
	private final String password = "rooter123!";
	
	private static final String INSERT_USER_SQL = "INSERT INTO users" +
		" (email, password, username, profilePicture) VALUES " +
		" (?, ?, ?, ?);";
	
	public void insertRecord(String userEmail, String userPassword, String username, String profilePicture) throws SQLException {
		System.out.println(INSERT_USER_SQL);
		
		try (
			Connection connection = DriverManager.getConnection(url, user, password);
			
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
				preparedStatement.setString(1, userEmail);
				preparedStatement.setString(2, userPassword);
				preparedStatement.setString(3, username);
				preparedStatement.setString(4, profilePicture);
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// throw exception here
				printSQLException(e);
			}
	}
	
	public static void printSQLException(SQLException ex) {
		for (Throwable e: ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				
				while (t != null) {
					System.err.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
