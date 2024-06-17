<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style>
	
	.table{
		display:flex;
		justify-content:center;
		align-items:center;
	}
	
	.err{
		color:red;
		text-align:center;
	}
</style>
</head>
<body>
<jsp:include page="header.html"></jsp:include>

	<form action="AddCourseServlet" method="post">
		<table class="table">
		<%-- <%
    		String errorMessage = (String) request.getAttribute("errorMessage");
    		if (errorMessage != null) {
		%>
        	<p style="color: red; text-align:center;"><%= errorMessage %></p>
		<%
    		}
		%> --%>
			<div  class="err" >${error}</div>
			<tr>
				<td>Id</td>
				<td>
					<input type="text" name="id" class="form-control" value="${course.id}"/>
				<td>
			</tr>
		
			<tr>
				<td>Name</td>
				<td>
					<input type="text" name="name" class="form-control" value="${course.name}"/>
				<td>
			</tr>
		
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Add Student" class="btn btn-primary"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>