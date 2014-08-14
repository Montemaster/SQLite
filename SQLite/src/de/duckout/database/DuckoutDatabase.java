package de.duckout.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DuckoutDatabase {

	public void createTable(Connection connection) {
		String createTable = "CREATE TABLE duckout "
				+ "(ID INT PRIMARY KEY NOT NULL,"
				+ "VALUE TEXT NOT NULL)";

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(createTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}