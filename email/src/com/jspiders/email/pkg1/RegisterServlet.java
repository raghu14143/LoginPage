package com.jspiders.email.pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		
		String url="header.html";
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.include(req, resp);
		
		resp.setContentType("text/html");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String[] gender=req.getParameterValues("gender");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String[] country=req.getParameterValues("country");
		Long contact=Long.parseLong(req.getParameter("contact"));
		
		int status=HelperClass.insert(name, email, password, gender[0], dob, address, city, state, country[0], contact);
		if(status==1)
		{
			out.println("Your Details are saved");
		}
		String url2="login.html";
		RequestDispatcher dispatcher2 = req.getRequestDispatcher(url2);
		dispatcher2.include(req, resp);
		
	String url1="footer.html";
	RequestDispatcher dispatcher1 = req.getRequestDispatcher(url1);
	dispatcher1.include(req, resp);
	}
}
