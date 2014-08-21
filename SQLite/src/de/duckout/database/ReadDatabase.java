package de.duckout.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDatabase {

	public void readData(Connection connection){
		String readData = "SELECT * FROM duckout";
		
		try {
			Statement statement = connection.createStatement();
			//executeQuery returns a ResultSet
			ResultSet resultSet = statement.executeQuery(readData);
			
			//The ResultSet contains the data
			while(resultSet.next()){
				//Get the column "VALUE" from the ResultSet
				String value = resultSet.getString("VALUE");
				System.out.println(value);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
