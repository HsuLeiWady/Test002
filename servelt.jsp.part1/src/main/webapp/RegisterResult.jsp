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
        String name=request.getParameter("fullname");
        out.println("Name:"+name);
        %>
        <br>
         <%
        String date=request.getParameter("date");
        out.println("Date:"+date);
        %>
           <br>
         <%
        String gender=request.getParameter("gender");
        out.println("Gender:"+gender);
        %>
           <br>
         <%
         String[] subjects=request.getParameterValues("subjects");
         for (String subject: subjects) {      
       
       out.print("Subject:"+subject);
     }
         
        %>
</body>
</html>