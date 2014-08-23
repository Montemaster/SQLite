package de.duckout.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Duckout.de
 */
public class InsertIntoDatabase {

	/**
	 * Inserts exactly one line into the TABLE duckout
	 * @param connection
	 */
	public void insertOneLine(Connection connection) {
		String insertData = "INSERT INTO duckout VALUES (1,\"First Value\")";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(insertData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Using PreparedStatement to insert data
	 * @param connection
	 */
	public void preparedStatement(Connection connection) {
		// The questionmark is used as a placeholder
		String insertData = "INSERT INTO duckout (id, value) VALUES (?, ?)";

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(insertData);

			// Set "placeholder" one
			preparedStatement.setInt(1, 2);
			// Set "placeholder" two
			preparedStatement.setString(2, "Value");
			// Execute the Statement
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Using a Batch Job to insert data
	 * @param connection
	 */
	public void insertBatch(Connection connection) {
		String insertData = "INSERT INTO duckout VALUES (?, ?)";

		try {
			// Auto Commit is enabled by default.
			// To handle the commit manually disable Auto Commit
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection
					.prepareStatement(insertData);

			// Set ID and VALUE
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Duckout");
			// Add the Statement to the Batch
			preparedStatement.addBatch();

			// The same procedure...
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "Next");
			preparedStatement.addBatch();

			// Execute both: the first and the second statement
			preparedStatement.executeBatch();

			// Enable Auto Commit
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mockup data with a certain amount
	 * @param connection
	 * @param amount
	 */
	public void mockupData(Connection connection, int amount) {

		String insertData = "INSERT INTO duckout VALUES (?, ?)";
		try {

			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection
					.prepareStatement(insertData);
			
			for (int i = 1; i <= amount; i++) {
				
				String value = "Value "+i;
				
				preparedStatement.setInt(1, i);
				preparedStatement.setString(2, value);
				
				preparedStatement.addBatch();
			}
			
			preparedStatement.executeBatch();

			connection.setAutoCommit(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}