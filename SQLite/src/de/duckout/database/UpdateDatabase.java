package de.duckout.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Duckout.de
 * Offers UPDATE methods to the database
 */
public class UpdateDatabase {

	/**
	 * Updates the table duckout. Uses the id to change a value.
	 * @param connection
	 * @param value
	 * @param id
	 */
	public void updateById(Connection connection, String value, int id){
		String update = "UPDATE duckout SET Value = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			//Use Parameters to set ID and VALUE
			preparedStatement.setString(1, value);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}