<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="emp" class="servlet.jsp.part3.Employee" scope="request"></jsp:useBean>
	<jsp:getProperty  name="emp" property="id"/>
	<jsp:getProperty  name="emp" property="name"/>
</body>
</html>