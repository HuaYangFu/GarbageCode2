package com.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class connet {

	private Connection con = null;

	public Connection getConn(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "2023645");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return con ;
	}
}
