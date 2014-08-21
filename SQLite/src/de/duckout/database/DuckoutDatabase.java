package de.duckout.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DuckoutDatabase {

	public void createTable(Connection connection) {
		String createTable = "CREATE TABLE IF NOT EXISTS duckout "
				+ "(ID INT PRIMARY KEY NOT NULL," + "VALUE TEXT NOT NULL)";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(createTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cleanTable(Connection connection) {
		String cleanTable = "DELETE FROM duckout";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(cleanTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

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
		String query = "INSERT INTO duckout (id, value) VALUES (?, ?)";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "Value");
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertBatch(Connection connection){
		String query = "INSERT INTO duckout VALUES (?, ?)";
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Duckout");
			preparedStatement.addBatch();
			
			preparedStatement.clearParameters();
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "Next");
			preparedStatement.addBatch();
			
			preparedStatement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertAutoIncrement(Connection connection) {
		String query = "INSERT INTO duckout (id, value) VALUES (?, ?)";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setString(2, "Value");
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}