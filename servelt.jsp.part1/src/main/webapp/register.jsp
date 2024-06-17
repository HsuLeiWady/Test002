<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
     Enter your name<input type="text" name="fullname"/><br>
     Date<input type="date" name="date"/><br>
     Male<input type="radio" name="gender" value="Male">
     Female<input type="radio" name="gender" value="Female"><br>
     Subject <select name="subjects" multiple>
      			<option value="Java">Java</option>
      			<option value="PHP">PHP</option>
      			<option value="C#">C#</option>
      			
             </select><br>
             <input type="submit" value="register">
  </form>
</body>
</html>