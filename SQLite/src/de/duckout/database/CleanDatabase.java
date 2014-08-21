package de.duckout.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author duckout.de
 * Is used to execute several DELETE operations
 */
public class CleanDatabase {

	/**
	 * Deletes all values in the table
	 * @param connection
	 */
	public void cleanTable(Connection connection) {
		String cleanTable = "DELETE FROM duckout";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(cleanTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deletes a certain value
	 * @param connection
	 * @param value
	 */
	public boolean deleteValue(Connection connection, String value) {
		String deleteValue = "DELETE FROM duckout WHERE VALUE = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteValue);
			//Uses the Parameter 'value' which will be deleted
			preparedStatement.setString(1, value);
			
			return preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}	
	
	
}
