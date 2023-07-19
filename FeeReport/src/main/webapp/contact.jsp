<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.19/dist/sweetalert2.min.css">

<style>
.footer {
	margin-top: 100px;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2>Contact Us</h2>
				<form action="ContactServlet" method="post">
					<div class="form-group">
						<label for="name">Name:</label> <input type="text" name="name"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="email" name="email"
							class="form-control">
					</div>
					<div class="form-group">
						<label for="message">Message:</label>
						<textarea name="message" class="form-control"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.19/dist/sweetalert2.min.js"></script>
	<script>
    // Function to show success message
    function showSuccessMessage(message) {
        Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: message,
            timer: 2000,
            showConfirmButton: false
        });
    }

    // Function to show error message
    function showErrorMessage(message) {
        Swal.fire({
            icon: 'error',
            title: 'Error!',
            text: message
        });
    }
</script>

	<script>
    <%-- Show success message if available --%>
    <% if (session.getAttribute("successMessage") != null) { %>
        showSuccessMessage('<%= session.getAttribute("successMessage") %>');
        <% session.removeAttribute("successMessage"); %>
    <% } %>

    <%-- Show error message if available --%>
    <% if (session.getAttribute("errorMessage") != null) { %>
        showErrorMessage('<%= session.getAttribute("errorMessage") %>');
        <% session.removeAttribute("errorMessage"); %>
    <% } %>
</script>


	<%@include file="footer.jsp"%>
</body>
</html>
