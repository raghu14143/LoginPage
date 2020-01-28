package com.jspiders.email.pkg1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePageServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		String url1="header.html";
		RequestDispatcher dispatcher1 = req.getRequestDispatcher(url1);
		dispatcher1.include(req, resp);
		
		String email=null;
		HttpSession session=req.getSession();
		email=(String)session.getAttribute("email");
		
		if(email!=null)
		{
			String url3="links.html";
			RequestDispatcher dispatcher3=req.getRequestDispatcher(url3);
			dispatcher3.include(req, resp);
		}
		else
		{
			String url4="login.html";
			RequestDispatcher dispatcher4=req.getRequestDispatcher(url4);
			dispatcher4.include(req, resp);
		}
		String url2="footer.html";
		RequestDispatcher dispatcher2 = req.getRequestDispatcher(url2);
		dispatcher2.include(req, resp);
	}
}
