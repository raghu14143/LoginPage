package com.jspiders.email.pkg1;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class Validation 
{
	public static boolean verify(String email,String password)
	{
		boolean status=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			con=ConnectionProvider.giveConnection();
		
			String query="select * from user where email=? and password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				status=true;
			}
			
		}
		catch(SQLException e)
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
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		return status;
	}
}
