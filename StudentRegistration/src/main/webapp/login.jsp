<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/test.css">
<title> Student Registration LGN001 </title>
</head>
<body class="login-page-body"> 
  
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <p>Please check your data again.</p>
          </div>
        </div>
       <form action="LoginServlet" method="post">
          <input type="text" placeholder="User ID" />
          <input type="password" placeholder="Password" />
          <button>login</button>
          <p class="message">Not registered? <a href="USR001">Create an account</a></p>
        </form>
      </div>
    </div>
</body>

</html>