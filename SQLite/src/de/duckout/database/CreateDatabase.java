package de.duckout.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Duckout.de
 */
public class CreateDatabase {

	/**
	 * Creates the TABLE duckout (ID, VALUE)
	 * @param connection
	 */
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
	
}
