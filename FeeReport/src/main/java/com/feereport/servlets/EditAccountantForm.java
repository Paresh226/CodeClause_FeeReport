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

@WebServlet("/EditAccountantForm")
public class EditAccountantForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        AccountantBean bean = AccountantDao.getRecordById(id);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Accountant</title>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("header.jsp").include(request, response);
        out.println("<div class='container mt-5'>");
 
        out.println("<div class='row justify-content-center'>");
        out.println("<div class='col-md-6 offset-md-3'>");
        out.print("<h1>Edit Accountant Form</h1>");
        out.print("<form action='EditAccountant' method='post'>"); // Add onsubmit attribute
        out.print("<table class='table table-bordered'>");
        out.print("<tr><td><input type='hidden' name='id' value='" + bean.getId() + "' /></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + bean.getName() + "' class='form-group'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + bean.getEmail() + "' class='form-group'/></td></tr>");
        out.print("<tr><td>Password:</td><td><input type='text' name='password' value='" + bean.getPassword() + "' class='form-group'/></td></tr>");
        out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;' class='form-group'>" + bean.getAddress() + "</textarea></td></tr>");
        out.print("<tr><td>Contact No:</td><td><input type='tel' name='contact' value='" + bean.getContact() + "' class='form-group' maxlength='10'pattern=\"[0-9]{10}\"/></td></tr>");
        out.print("<tr><td colspan='2' align='center'><input type='submit' class='btn btn-primary' value='Submit'/></td></tr>"); // Add value to the submit button
        out.print("</table>");
        out.print("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        request.getRequestDispatcher("footer.jsp").include(request, response);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
