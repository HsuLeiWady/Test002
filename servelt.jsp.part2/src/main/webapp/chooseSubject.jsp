<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Choose Subjects</title>
</head>
<body>
<h1>Choose Subjects</h1>
    <form action="ChooseSubjectServlet" method="post">    
            <input type="checkbox" name="selectedSubjects" value="${subject}">
            <label for="${subject}">${subject
</body>
</html>