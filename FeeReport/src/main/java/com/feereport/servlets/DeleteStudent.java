package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.dao.StudentDao;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String srollno=request.getParameter("rollno");
		int rollno=Integer.parseInt(srollno);
		StudentDao.delete(rollno);
		out.println("<script>");
		out.println("alert('Student " + rollno + " Deleted SuccessFully!');");
		out.println("window.location.href = 'AccountantDashboard.jsp';");
		out.println("</script>");
	 
	}
}