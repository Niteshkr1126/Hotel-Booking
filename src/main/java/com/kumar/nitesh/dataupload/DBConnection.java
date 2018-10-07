package com.kumar.nitesh.dataupload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels?autoReconnect=true&useSSL=false", "root", "9852@Nit");

		return connection;
	}

	public static void main(String[] args) {
		try {
			getConnection();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
