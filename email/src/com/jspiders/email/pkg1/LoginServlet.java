package com.jspiders.email.pkg1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String url="header.html";
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.include(req, resp);
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		boolean bool=Validation.verify(email, password);
		if(bool==true)
		{
			HttpSession session=req.getSession();
			session.setAttribute("email", email);
			resp.sendRedirect("HomePageServlet");
		}
		else
		{
			String url3="login.html";
			RequestDispatcher dispatcher3 = req.getRequestDispatcher(url3);
			dispatcher3.include(req, resp);
			out.println("Invalid username or password");
		}
		
		String url1="footer.html";
		RequestDispatcher dispatcher1 = req.getRequestDispatcher(url1);
		dispatcher1.include(req, resp);
		
	}
}
