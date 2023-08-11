<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.radius {
	text-align: center;
	margin-left: 420px;
	margin-right: 420px;
}
.success{
	margin-top:20px;
}
</style>
<%@include file="/components/allincss.jsp"%>
<title>Update User Registration</title>
</head>
<body>
	<%@include file="/WEB-INF/views/Menu.jsp"%>
	<div class="container p-5">
		<div class=" radius alert alert-danger" role="alert">
			<h5>
				<%
				if (request.getAttribute("inserted") != null) {
					out.println(request.getAttribute("inserted"));
				} else {
					out.println("Updated Successfully");
				}
				%>
			</h5>
		</div>
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card point-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Register / Sign up</p>

						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input autocomplete="off"
									required value="<%=request.getAttribute("name")%>" name="name"
									type="text" class="form-control" />
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input
									autocomplete="off" required name="email"
									value="<%=request.getAttribute("email")%>" type="email"
									class="form-control" />
							</div>

							<div class="mb-3">
								<label class="form-label">Phone No.</label> <input
									autocomplete="off" required name="phone_no"
									value="<%=request.getAttribute("phone_no")%>" type="number"
									class="form-control" />
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label> <input
									autocomplete="off" required name="address"
									value="<%=request.getAttribute("address")%>" type="text"
									class="form-control" />
							</div>


							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
							<br>
							
						</form>
						<form action="logout" method="post">
									<button type="submit" class="btn bg-success text-white col-md-12">Logout</button>
								
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>