package de.duckout.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Duckout.de
 */
public class DatabaseConnection {
	
	/**
	 * Establishes a standard SQLite Connection
	 * @return Connection
	 */
	public Connection establishConnection(){
		
		try {
			//Get the JDBC driver
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			//Establish the database connection to database "duckout.db"
			Connection connection = DriverManager.getConnection("jdbc:sqlite:duckout.db");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Return null in case Connection wasn't returned
		return null;
	}
	
	/**
	 * Closes the SQL Connection
	 * @param connection
	 */
	public void cloaseConnection(Connection connection){
		try {
			//Close SQL connection
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}