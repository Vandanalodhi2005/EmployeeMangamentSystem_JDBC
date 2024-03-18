package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String  DATABASE_URL = "jdbc:mysql://localhost:3306/EmployeeMS";
	private static final String  USERNAME = "root";
	private static final String  PASSWORD ="Vandana@12";
	
	
		public  DatabaseUtil() {
		try {
			Class.forName("DRIVER_PATH");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public Connection getConnection() throws SQLException {
			return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		}

}
