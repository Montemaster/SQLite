package de.duckout.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	public void establishConnection() throws ClassNotFoundException, SQLException{
		
		//Get the JDBC driver
		Class.forName("org.sqlite.JDBC");
		
		//Establish the database connection to database "duckout.db"
		Connection connection = DriverManager.getConnection("jdbc:sqlite:duckout.db"); 
	}
	
}