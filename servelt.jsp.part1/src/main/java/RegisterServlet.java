

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname=request.getParameter("fullname");
		String date=request.getParameter("date");
		String gender=request.getParameter("gender");
		String [] subjects=request.getParameterValues("subjects");
		  
		  PrintWriter out=response.getWriter();
		  
		  out.println("Name:"+fullname);
		  out.println("Date:"+date);
		  out.println("Gender:"+gender);
		  for(String subject:subjects) {
			  out.print("Subject:"+subject);  
			   
		  
		}
	}

}
