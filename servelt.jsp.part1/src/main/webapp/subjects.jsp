<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action="SubjectServlet" method="get">
     Enter your name<input type="text" name="fullname"/>
     Subject <select name="subjects" multiple>
      			<option value="Java">Java</option>
      			<option value="PHP">PHP</option>
      			<option value="C#">C#</option>
      			
             </select>
             <input type="submit" value="submit">
  </form>
</body>
</html>
