

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        public WelcomeServlet() {
        super();
            }
        
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name=request.getParameter("fullname");
			String ageStr=request.getParameter("age");
			int age=Integer.parseInt(ageStr);
			PrintWriter out=response.getWriter();
	    	out.print(name);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name=request.getParameter("fullname");
			PrintWriter out=response.getWriter();
	    	out.print(name);

	}

}
