<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	    String paramName=request.getParameter("pname");
	    String paramValue=config.getInitParameter(paramName);
	    out.print("driver name is "+paramValue);
	
	
	%>
</body>
</html>