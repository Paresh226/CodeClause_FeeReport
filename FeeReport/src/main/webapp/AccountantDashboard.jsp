<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="com.feereport.bean.*" %>
<%@ page import="com.feereport.dao.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accountant Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        .right {
            margin-top: 10px;
            margin-right: 10px;
            text-align: right;
        }

        .container {
            margin-top: 20px;
        }

        .footer {
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="right">
        <button type="submit" class="btn btn-primary">
            <a href="LogoutAccountant" style="color: white; text-decoration: none;">Logout</a>
        </button>
    </div>

    <h2 class="text-left">Welcome, Accountant</h2>
    <ul class="nav nav-tabs">
        <li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#addstudent">Add Student</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#viewstudent">View Student</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#searchstudent">Search Student</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#duefees">Due Fees</a></li>
        <li class="nav-item"><a class="nav-link" data-toggle="tab" href="#downloadreport">View Report</a></li>
    </ul>

    <div class="tab-content">
        <div id="addstudent" class="tab-pane fade show active">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <h1 class="text-center">Add Student Form</h1>
                        <form action="AddStudent" method="post">
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input type="text" name="name" id="name" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" name="email" id="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Gender:</label>
                                <div class="form-check">
                                    <input type="radio" name="sex" id="male" value="Male" class="form-check-input">
                                    <label for="male" class="form-check-label">Male</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" name="sex" id="female" value="Female" class="form-check-input">
                                    <label for="female" class="form-check-label">Female</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="course">Course:</label>
                                <select name="course" id="course" class="form-control" required>
                                    <option>Java</option>
                                    <option>.Net</option>
                                    <option>PHP</option>
                                    <option>Android</option>
                                    <option>Hadoop</option>
                                    <option>Selenium</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="fee">Fee:</label>
                                <input type="number" name="fee" id="fee" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="paid">Paid:</label>
                                <input type="number" name="paid" id="paid" class="form-control" value="0">
                            </div>
                            <div class="form-group">
                                <label for="due">Due:</label>
                                <input type="number" name="due" id="due" class="form-control" value="0">
                            </div>
                            <div class="form-group">
                                <label for="address">Address:</label>
                                <textarea name="address" id="address" class="form-control" rows="4"></textarea>
                            </div>
                          <div class="form-group">
									<label for="contact">Contact:</label> <input type="tel"
										class="form-control" id="contact" name="contact" required maxlength="10"
										pattern="[0-9]{10}"
										title="Please enter a 10-digit phone number" />
								</div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary" value="Save Student">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div id="viewstudent" class="tab-pane fade">
            <div class="container">
                <h1 class="text-center">View Students</h1>
                <%
                    List<StudentBean> list = StudentDao.getAllRecords();
                %>
                <table class="table table-bordered table-striped">
                    <tr>
                        <th>Roll No.</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Course</th>
                        <th>Fee</th>
                        <th>Paid</th>
                        <th>Due</th>
                        <th>Address</th>
                        <th>Contact</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    <% for (StudentBean bean : list) { %>
                        <tr>
                            <td><%= bean.getRollno() %></td>
                            <td><%= bean.getName() %></td>
                            <td><%= bean.getEmail() %></td>
                            <td><%= bean.getSex() %></td>
                            <td><%= bean.getCourse() %></td>
                            <td><%= bean.getFee() %></td>
                            <td><%= bean.getPaid() %></td>
                            <td><%= bean.getDue() %></td>
                            <td><%= bean.getAddress() %></td>
                            <td><%= bean.getContact() %></td>
                            <td>
                                <a href="EditStudentForm?rollno=<%= bean.getRollno() %>" class="btn btn-primary">Edit</a>
                            </td>
                            <td>
                                <a href="DeleteStudent?rollno=<%= bean.getRollno() %>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
            </div>
        </div>

        <div id="searchstudent" class="tab-pane fade">
            <div class="container">
                <h1 class="text-center">Search Student </h1>
                <form action="SearchStudent" method="post">
                    <div class="text-center">
                        <label for="rollno">Rollno:</label>
                        <input type="number" name="rollno" id="rollno" class="col-md-4" required>
                     <div class="text-center">
                        <input type="submit" class="btn btn-primary" value="Search">
                    </div>
                    </div>
                          
                </form>
            </div>
        </div>

        <div id="duefees" class="tab-pane fade">
            <div class="container">
                <h1 class="text-center">Due Fees</h1>
                <%
                    List<StudentBean> list1 = StudentDao.getAllRecords();
                %>
                <table class="table table-bordered table-striped">
                    <tr>
                        <th>Rollno</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Course</th>
                        <th>Fee</th>
                        <th>Paid</th>
                        <th>Due</th>
                        <th>Address</th>
                        <th>Contact</th>
                        <th>Update Fees</th>
                    </tr>
                    <% for (StudentBean bean : list1) { %>
                        <tr>
                            <td><%= bean.getRollno() %></td>
                            <td><%= bean.getName() %></td>
                            <td><%= bean.getEmail() %></td>
                            <td><%= bean.getSex() %></td>
                            <td><%= bean.getCourse() %></td>
                            <td><%= bean.getFee() %></td>
                            <td><%= bean.getPaid() %></td>
                            <td><%= bean.getDue() %></td>
                            <td><%= bean.getAddress() %></td>
                            <td><%= bean.getContact() %></td>
                            <td>
                                <a href="UpdateFees?rollno=<%= bean.getRollno() %>" class="btn btn-primary">Update Fees</a>
                            </td>
                        </tr>
                    <% } %>
                </table>
            </div>
        </div>

        <div id="downloadreport" class="tab-pane fade">
            <div class="right">
              
                <button id="download-pdf-btn" class="btn btn-primary">Print</button>
            </div>
            <div class="container">
                <h1 class="text-center">View Report</h1>
                <table class="table table-bordered table-striped" id="feedetails">
                    <tr>
                        <th>Rollno</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Course</th>
                        <th>Fee</th>
                        <th>Paid</th>
                        <th>Due</th>
                        <th>Address</th>
                        <th>Contact</th>
                    </tr>
                    <% for (StudentBean bean : list) { %>
                        <tr>
                            <td><%= bean.getRollno() %></td>
                            <td><%= bean.getName() %></td>
                            <td><%= bean.getEmail() %></td>
                            <td><%= bean.getSex() %></td>
                            <td><%= bean.getCourse() %></td>
                            <td><%= bean.getFee() %></td>
                            <td><%= bean.getPaid() %></td>
                            <td><%= bean.getDue() %></td>
                            <td><%= bean.getAddress() %></td>
                            <td><%= bean.getContact() %></td>
                        </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
