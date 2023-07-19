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


@WebServlet("/UpdateFees")
public class UpdateFees extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String srollno = request.getParameter("rollno");
        int rollno = Integer.parseInt(srollno);
        StudentBean bean = StudentDao.getRecordByRollno(rollno);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Student Form</title>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("header.jsp").include(request, response);
        out.println("<div class='container'>");

        out.print("<h1>Edit Student Form</h1>");
        out.print("<form action='EditFees' method='post'>");
        out.print("<table class='table'>");
        out.print("<tr><td><input type='hidden' name='rollno'  value='" + bean.getRollno() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' disabled name='name' value='" + bean.getName() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' disabled name='email' value='" + bean.getEmail() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Gender:</td><td><input type='text' name='sex' disabled value='" + bean.getSex() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Course:</td><td><input type='text' disabled name='course' value='" + bean.getCourse() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Fee:</td><td><input type='number' name='fee' value='" + bean.getFee() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Paid:</td><td><input type='number' name='paid' value='" + bean.getPaid() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Due:</td><td><input type='number' name='due' value='" + bean.getDue() + "' class='form-control'/></td></tr>");
        out.print("<tr><td>Address:</td><td><textarea name='address' disabled style='width:300px;height:100px;' class='form-control'>" + bean.getAddress() + "</textarea></td></tr>");
        out.print("<tr><td>Contact No:</td><td><input type='text' disabled name='contact' value='" + bean.getContact() + "' class='form-control'/></td></tr>");
        out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update' class='btn btn-primary'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.println("</div>");
        request.getRequestDispatcher("footer.jsp").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
