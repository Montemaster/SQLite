package de.duckout.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CleanDatabase {

	public void cleanTable(Connection connection) {
		String cleanTable = "DELETE FROM duckout";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(cleanTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
