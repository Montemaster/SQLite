package de.duckout.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDatabase {

	public void updateById(Connection connection, String value, int id){
		String update = "UPDATE duckout SET Value = ? WHERE id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, value);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
