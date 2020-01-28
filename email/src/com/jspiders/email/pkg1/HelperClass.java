package com.jspiders.email.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelperClass 
{
	public static int insert(String name,String email,String password,String gender,
			String dob,String address,String city,String state,String country,Long contact)
	{
		int status=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		try 
		{
			con=ConnectionProvider.giveConnection();
			String query="insert into user(name,email,password,gender,dob,address,city,state,country,contact) "+
					"values(?,?,?,?,?,?,?,?,?,?)";
			java.sql.Date date=DateConvertor.dateConversion(dob);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, gender);
			pstmt.setDate(5, date);
			pstmt.setString(6, address);
			pstmt.setString(7, city);
			pstmt.setString(8, state);
			pstmt.setString(9, country);
			pstmt.setLong(10, contact);
			int res=pstmt.executeUpdate();
			if(res!=0)
			{
				status=1;
			}
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con!=null)
				{
					con.close();
				}
				if(pstmt!=null)
				{
					pstmt.close();
				}
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return status;
	}
}
