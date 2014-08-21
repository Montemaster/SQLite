package de.duckout.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoDatabase {

	public void insertOneLine(Connection connection) {
		String insertData = "INSERT INTO duckout VALUES (1,\"First Value\")";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(insertData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void preparedStatement(Connection connection) {
		//The questionmark is used as a placeholder 
		String insertData = "INSERT INTO duckout (id, value) VALUES (?, ?)";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(insertData);
			
			//Set "placeholder" one
			preparedStatement.setInt(1, 2);
			//Set "placeholder" two
			preparedStatement.setString(2, "Value");
			//Execute the Statement
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertBatch(Connection connection){
		String insertData = "INSERT INTO duckout VALUES (?, ?)";

		try {
			//Auto Commit is enabled by default.
			//To handle the commit manually disable Auto Commit
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement = connection
					.prepareStatement(insertData);
			
			//Set ID and VALUE
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Duckout");
			//Add the Statement to the Batch
			preparedStatement.addBatch();
			
			preparedStatement.clearParameters();
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "Next");
			preparedStatement.addBatch();
			
			//Execute both: the first and the second statement
			preparedStatement.executeBatch();
			
			//Enable Auto Commit
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}