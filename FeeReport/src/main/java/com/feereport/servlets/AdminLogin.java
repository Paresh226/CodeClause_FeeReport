package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		try {
		if(email.equals("admin@gmail.com")&&password.equals("admin")){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			if (session == null || session.getAttribute("admin") == null || !session.getAttribute("admin").equals("true")) {
	            response.sendRedirect("index.jsp");
	        }
			else {
			out.println("<script>");
			out.println("alert('Welcome!, " + email + "');");
			out.println("window.location.href = 'AdminDashboard.jsp';");
			out.println("</script>");
			out.close();
			}
		}else{
			out.println("<script>");
			out.println("alert('Sorry, username or password error.!');");
			out.println("window.location.href = 'index.jsp';");
			out.println("</script>");
			out.close();
		}
	 
		}catch(Exception e)
		{
			  out.println("<script>");
	    		out.println("alert('Error!"+e.getMessage().toString()+"');");
	    		out.println("window.location.href = 'AdminDashboard.jsp';");
	    		out.println("</script>");
	    		out.close();
		}
	}
}

