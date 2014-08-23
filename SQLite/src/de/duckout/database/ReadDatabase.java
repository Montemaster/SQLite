package de.duckout.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Duckout.de
 */
public class ReadDatabase {

	/**
	 * Reads ALL Data from Database duckout
	 * Returns wheater the operation was successfully or not.
	 * @param connection
	 * @return boolean
	 */
	public boolean readData(Connection connection){
		String readData = "SELECT * FROM duckout";
		
		try {
			Statement statement = connection.createStatement();

			//Executes the query and returns the status
			boolean status = statement.execute(readData);
			
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Reads ALL Data from Database duckout
	 * Returns a ResultSet of the Data
	 * @param connection
	 * @return ResultSet
	 */
	public ResultSet readDataRS(Connection connection){
		String readData = "SELECT * FROM duckout";
		
		try {
			Statement statement = connection.createStatement();
			
			//executeQuery returns a ResultSet
			ResultSet resultSet = statement.executeQuery(readData);
			
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
