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
	    String name="AI";
		request.setAttribute("r","request scope");
	    session.setAttribute("user","AI User");
	    application.setAttribute("a","applcation scope");
	    
	%>
	<a herf="welcomesession.jsp">Second jsp page</a>
	
</body>
</html>