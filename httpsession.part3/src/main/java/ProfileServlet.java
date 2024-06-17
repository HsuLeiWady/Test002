

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ProfileServlet() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("linkk.jsp").include(request, response);
		
		//String pname=request.getParameter("username");
		String sname=(String)request.getSession().getAttribute("session_username");//session htae ka so d lo u ya dl
		
		if(sname!=null) {
			out.print("Welcome to profile");
			out.print("<br>Welcomw, "+sname);
			
		}else {
			out.print("Please login first");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
