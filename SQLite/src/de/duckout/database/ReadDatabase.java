package de.duckout.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDatabase {

	public boolean readData(Connection connection){
		String readData = "SELECT * FROM duckout";
		
		try {
			Statement statement = connection.createStatement();

			boolean status = statement.execute(readData);
			
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
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
