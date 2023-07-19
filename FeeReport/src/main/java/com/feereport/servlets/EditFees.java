package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.bean.StudentBean;
import com.feereport.dao.StudentDao;

@WebServlet("/EditFees")
public class EditFees extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int rollno = Integer.parseInt(request.getParameter("rollno"));

		int fee = Integer.parseInt(request.getParameter("fee"));
		int paid = Integer.parseInt(request.getParameter("paid"));
		int due = Integer.parseInt(request.getParameter("due"));

		try {
			StudentBean bean = new StudentBean(rollno, fee, paid, due);
			int status = StudentDao.updateFees(bean);
			if (status > 0) {
				out.println("<script>");
				out.println("alert('Fees Details Updated');");
				out.println("window.location.href = 'AccountantDashboard.jsp';");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('Failed to Update Fees Details...!');");
				out.println("window.location.href = 'AccountantDashboard.jsp';");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			out.println("<script>");
			out.println("alert('Error!" + e.getMessage().toString() + "');");
			out.println("window.location.href = 'AccountantDashboard.jsp';");
			out.println("</script>");
		}
	}

}
