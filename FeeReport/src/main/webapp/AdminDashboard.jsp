<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.feereport.bean.AccountantBean"%>
<%@ page import="com.feereport.dao.AccountantDao"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<style>
.right {
	margin-top: 10px;
	margin-right: 10px;
	text-align: right;
} 
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="right">
		<button type="submit" class="btn btn-primary">
			<a href="LogoutAdmin" style="color: white; text-decoration: none;">Logout</a>
		</button>
	</div>
	<div class="container mt-5">
		<h2 class="text-left">Welcome, Admin</h2>
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				data-toggle="tab" href="#addaccountants">Add Accountant</a></li>
			<li class="nav-item"><a class="nav-link" data-toggle="tab"
				href="#viewaccountants">View Accountants</a></li>

		</ul>

		<div class="tab-content">
			<div id="addaccountants" class="tab-pane fade show active">
				<div class="container mt-5">
					<div class="row">
						<div class="col-md-6 offset-md-3">
							<h2>Add Accountant</h2>
							<form action="AddAccontant" method="POST">
								<div class="form-group">
									<label for="name">Name:</label> <input type="text"
										class="form-control" id="name" name="name" required>
								</div>
								<div class="form-group">
									<label for="email">Email:</label> <input type="email"
										class="form-control" id="email" name="email" required>
								</div>
								<div class="form-group">
									<label for="password">Password:</label> <input type="text"
										class="form-control" id="password" name="password" required>
								</div>
								<div class="form-group">
									<label for="address">Address:</label> <input type="text"
										class="form-control" id="address" name="address" required>
								</div>
								<div class="form-group">
									<label for="contact">Contact:</label> <input type="tel"
										class="form-control" id="contact" name="contact" required maxlength="10"
										pattern="[0-9]{10}"
										title="Please enter a 10-digit phone number" />
								</div>

								<button type="submit" class="btn btn-primary">Register</button>
							</form>
						</div>
					</div>
				</div>
 
				<%@ include file="footer.jsp"%>
			</div>
			<div id="viewaccountants" class="tab-pane fade">
				<div class='container'>
					<h1>View Accountant</h1>
					<%
					List<AccountantBean> list = AccountantDao.getAllRecords();
					%>
					<table class='table table-bordered table-striped'>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Address</th>
							<th>Contact</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<%
						for (AccountantBean bean : list) {
						%>
						<tr>
							<td><%=bean.getId()%></td>
							<td><%=bean.getName()%></td>
							<td><%=bean.getEmail()%></td>
							<td><%=bean.getPassword()%></td>
							<td><%=bean.getAddress()%></td>
							<td><%=bean.getContact()%></td>
							<td><a href='EditAccountantForm.jsp?id=<%=bean.getId()%>'>Edit</a></td>
							<td><a href='DeleteAccountant?id=<%=bean.getId()%>'>Delete</a></td>
						</tr>
						<%
						}
						%>
					</table>
				</div>
				<%@ include file="footer.jsp"%>
				<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
