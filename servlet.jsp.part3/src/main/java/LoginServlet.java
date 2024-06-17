

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public LoginServlet() {
        super();        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		request.getRequestDispatcher("cookies_link.jsp").include(request, response);
		PrintWriter out=response.getWriter();
		
		if(password.equals("123")) {
			out.println("You are successfully login!!!");
			out.println("Welcome" + name);
			Cookie ck=new Cookie("username",name);
			response.addCookie(ck);
		}else {
			request.getRequestDispatcher("cookies_login.jsp").include(request, response);
			out.println("Sorry,username and password error");
			

		}
		out.close();
	}
}
