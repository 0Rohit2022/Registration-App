<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>All Registration</title>
<style>
.table {
	margin-top: 30px;
}
</style>
<%@include file="/components/allincss.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/Menu.jsp"%>

	<table class="table table-dark table-striped">
		<thead class="center">
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Phone_NO</th>
				<th scope="col">Address</th>
				<th scope="col">Delete</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<%
		ResultSet result = (ResultSet) request.getAttribute("result");
		while (result.next()) {
		%>
		<tbody class="center">
			<tr>
				<td><%=result.getString(1)%></td>
				<td><%=result.getString(2)%></td>
				<td><%=result.getString(3)%></td>
				<td><%=result.getString(4)%></td>
				<td><a href="delete?email=<%=result.getString(2)%>">Delete</a>
				<td><a
					href="update?name=<%=result.getString(1)%>&email=<%=result.getString(2)%>&phone_no=<%=result.getString(3)%>&address=<%=result.getString(4)%>">Update</a>
			</tr>

		</tbody>
		<%
		}
		%>

	</table>
	<form action="logout" method="post">
	<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
		<button type="submit" class="btn btn-primary btn-lg">Logout</button>
	</div>
	</form>
</body>
</html>