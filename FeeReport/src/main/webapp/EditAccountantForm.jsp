<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.feereport.bean.*" %>
<%@ page import="com.feereport.dao.*" %>
 <%
   
    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);
    AccountantBean bean = AccountantDao.getRecordById(id);
%>
<html>
<head>
    <title>Edit Accountant</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" >
    <link rel="stylesheet" href="style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container mt-5">
       
            <div class="col-md-8 offset-md-3">
                <h1>Edit Accountant Form</h1>
                <form action="EditAccountant" method="post">
                    <table class="table table-bordered">
                        <tr>
                            <td><input type="hidden" name="id" value="<%= bean.getId() %>"/></td>
                        </tr>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" value="<%= bean.getName() %>" class="col-md-6"/></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="email" name="email" value="<%= bean.getEmail() %>" class="col-md-6"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" value="<%= bean.getPassword() %>" class="col-md-6"/></td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><textarea name="address" style="width:300px;height:100px;" class="col-md-6"><%= bean.getAddress() %></textarea></td>
                        </tr>
                        <tr>
                            <td>Contact No:</td>
                            <td><input type="text" name="contact" value="<%= bean.getContact() %>" class="col-md-6"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="Submit"/></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    
    <jsp:include page="footer.jsp" />
     
</body>
</html>
