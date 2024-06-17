<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Information</h2>



<p>Name: <jsp:getProperty name="student" property="name"/></p>
<p>Age: <jsp:getProperty name="student" property="age"/></p>

	
</body>
</html>;
