package com.feereport.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feereport.bean.StudentBean;
import com.feereport.dao.StudentDao;

@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>View Student</title>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");
       // request.getRequestDispatcher("navaccountant.html").include(request, response);
        out.println("<div class='container'>");

        out.print("<h1>View Students</h1>");

        List<StudentBean> list = StudentDao.getAllRecords();
        out.println("<table class='table table-bordered table-striped'>");
        out.print("<tr><th>Rollno</th><th>Name</th><th>Email</th><th>Gender</th><th>Course</th><th>Fee</th><th>paid</th><th>due</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
        for (StudentBean bean : list) {
            out.print("<tr><td>" + bean.getRollno() + "</td><td>" + bean.getName() + "</td><td>" + bean.getEmail()
                    + "</td><td>" + bean.getSex() + "</td><td>" + bean.getCourse() + "</td><td>" + bean.getFee()
                    + "</td><td>" + bean.getPaid() + "</td><td>" + bean.getDue() + "</td><td>" + bean.getAddress()
                    + "</td><td>" + bean.getContact() + "</td><td><a href='EditStudentForm?rollno=" + bean.getRollno()
                    + "' class='btn btn-primary'>Edit</a></td><td><a href='DeleteStudent?rollno=" + bean.getRollno()
                    + "' class='btn btn-danger'>Delete</a></td></tr>");
        }
        out.println("</table>");
        out.println("</div>");
       // request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
