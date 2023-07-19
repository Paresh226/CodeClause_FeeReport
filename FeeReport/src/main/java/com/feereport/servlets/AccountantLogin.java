package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feereport.dao.AccountantDao;

@WebServlet("/AccountantLogin")
public class AccountantLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean status = AccountantDao.validate(email, password);
		try {
			if (status) {
				HttpSession session = request.getSession();
				session.setAttribute("accountant", "true");
				out.println("<script>");
				out.println("alert('WelCome!," + email + "');");
				out.println("window.location.href = 'AccountantDashboard.jsp';");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('Sorry, username or password error.!');");
				out.println("window.location.href = 'index.jsp';");
				out.println("</script>");
			}
		} catch (Exception e) {
			out.println("<script>");
			out.println("alert('Error!" + e.getMessage().toString() + "');");
			out.println("window.location.href = 'index.jsp';");
			out.println("</script>");
		}
	}
}
