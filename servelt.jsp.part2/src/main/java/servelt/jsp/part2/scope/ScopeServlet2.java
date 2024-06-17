package servelt.jsp.part2.scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ScopeServlet2")
public class ScopeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ScopeServlet2() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	String r=(String)request.getAttribute("r");//get value from request object
		    String s=(String)request.getSession().getAttribute("s");//get value from session object
		    String a=(String)request.getServletContext().getAttribute("a");//get value from app object
		   
		    request.getRequestDispatcher("scopeobject1.jsp").include(request, response);
		    PrintWriter out=response.getWriter();
		    out.print(r+"--"+s+"--"+a);
		   		}
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
