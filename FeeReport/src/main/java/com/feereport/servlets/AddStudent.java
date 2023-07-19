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

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String sex = request.getParameter("sex");
			String course = request.getParameter("course");
			int fee = Integer.parseInt(request.getParameter("fee"));
			int paid = Integer.parseInt(request.getParameter("paid"));
			int due = Integer.parseInt(request.getParameter("due"));
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			StudentBean bean = new StudentBean(name, email, sex, course, fee, paid, due, address, contact);
			int status = StudentDao.save(bean);
			if (status > 0) {
				out.println("<script>");
				out.println("alert('Student " + name + " added successfully.!');");
				out.println("window.location.href = 'AccountantDashboard.jsp';");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('Failed to add Student.!');");
				out.println("window.location.href = 'AccountantDashboard.jsp';");
				out.println("</script>");
				out.close();
			}
		} catch (Exception e) {
			out.println("<script>");
			out.println("alert('Error!" + e.getMessage().toString() + "');");
			out.println("window.location.href = 'AccountantDashboard.jsp';");
			out.println("</script>");
			out.close();
		}
	}
}
