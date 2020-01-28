package com.jspiders.email.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConnectionProvider 
{
	public static Connection giveConnection()
	{
		Connection con=null;
		try 
		{
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl="jdbc:mysql://localhost:3306/email?user=root&password=root";
			con=DriverManager.getConnection(dburl);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
