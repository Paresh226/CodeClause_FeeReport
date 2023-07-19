package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.bean.ContactBean;
import com.feereport.dao.ContactDAO;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		try {
			ContactBean bean = new ContactBean(name, email, message);
			int status = ContactDAO.save(bean);
			if (status > 0) {
				request.getSession().setAttribute("successMessage", "Thank you for your message!");
			} else {
				request.getSession().setAttribute("errorMessage", "An error occurred while processing your message.");
			}
			response.sendRedirect("contact.jsp");
			out.close();
		} catch (Exception e) {
			out.println("<script>");
			out.println("alert('Error!" + e.getMessage().toString() + "');");
			out.println("window.location.href = 'AdminDashboard.jsp';");
			out.println("</script>");
			out.close();
		}
	}

}
