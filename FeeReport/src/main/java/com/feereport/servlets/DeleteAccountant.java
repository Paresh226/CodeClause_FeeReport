package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.dao.AccountantDao;

@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		AccountantDao.delete(id);
		out.println("<script>");
		out.println("alert('Accountant Deleted successfully.!');");
		out.println("window.location.href = 'AdminDashboard.jsp';");
		out.println("</script>");
	}
}

