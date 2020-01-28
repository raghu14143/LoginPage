package com.jspiders.email.pkg1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvertor 
{
	public static java.sql.Date dateConversion(String dob)
	{
		java.sql.Date date2=null;
		SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
		try 
		{
			java.util.Date date1=format.parse(dob);
			date2=new java.sql.Date(date1.getTime());
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return date2;
	}
}
