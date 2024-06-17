
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HwSubServlet")
public class HwSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public HwSubServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  PrintWriter out=response.getWriter();
		   String[] language = request.getParameterValues("subject");
		    	    
		    if (language != null && language.length > 0) {
		              out.println("<p>Your Professional is :</p>");
		              out.println("<ol>");

		            for (String sub : language) {
		                 out.println("<li>" + sub + "</li>");
		            }
		              out.println("</ol>");
		            } else {
		            request.getRequestDispatcher("hwSubject.jsp").include(request, response);
		              out.println("<p>Choose One!!!</p>");
		            }
		      
		    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
