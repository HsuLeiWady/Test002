<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <!-- <jsp:useBean id="p" class="foo.Person" scope="request"/>
    <jsp:useBean id="e" class="foo.Employeee" scope="request"/>
    
    <jsp:getProperty property="name" name="p"/>
    
    <jsp:getProperty property="id" name="e"/>
    <jsp:getProperty property="name" name="e"/> -->  
    <form action="PersonServlet">
    	<input type="submit" value="Refresh">
    </form>
    
    Person-${p.name} <br>
    Employee Info<br>
    Id-${sessionScope.e.id}<br>
    Name-${sessionScope.e.name}<br>  
 	Friend Name-${sessionScope.e.friend.name}<br>
    
    Friend Info<br>
    Name-${applicationScope.f.name}
    
    
</body>
</html>