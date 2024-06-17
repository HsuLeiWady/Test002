

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		request.getRequestDispatcher("linkkk.jsp").include(request, response);
		PrintWriter out=response.getWriter();
		
		if(password.equals("123")) {
			request.getSession().setAttribute("session_username",name);//httpsession add value
			out.print("Your are successfully login !");
			out.print("<br>Welcome "+name);
			
		}else {
			out.print("Sorry,useename and password error!");
			request.getRequestDispatcher("login.jsp").include(request, response);
			
		}
		
		
	}

}
