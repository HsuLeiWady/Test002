<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean  class="servlet.jsp.part3.Employee" id="emp" scope="request"></jsp:useBean>
	<jsp.setProperty  name="emp" property="id" value="1"/>
	<jsp.setProperty  name="emp" property="name" value="AAAA"/>
	
	<jsp:getPeoperty name="emp" property="name"/>	
</body>
</html>