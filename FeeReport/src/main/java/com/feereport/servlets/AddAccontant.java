package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.bean.AccountantBean;
import com.feereport.dao.AccountantDao;


@WebServlet("/AddAccontant")
public class AddAccontant extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();

		String name=request.getParameter("name");
	 	String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
   try {
		AccountantBean bean=new AccountantBean(name, email, password, address, contact);
		int status=AccountantDao.save(bean);
		if(status>0)
		{
		out.println("<script>");
		out.println("alert('Accountant " + name + " added successfully.!');");
		out.println("window.location.href = 'AdminDashboard.jsp';");
		out.println("</script>");
		out.close();
        }
		else
		{
			out.println("<script>");
			out.println("alert('Failed to Add Accountant.!');");
			out.println("window.location.href = 'AdminDashboard.jsp';");
			out.println("</script>");
			out.close();
		}
      }
        catch(Exception e)
        {
        	out.println("<script>");
        	out.println("alert('Error!"+e.getMessage().toString()+"');");
        	out.println("window.location.href = 'AdminDashboard.jsp';");
        	out.println("</script>");
        }
	}
}
