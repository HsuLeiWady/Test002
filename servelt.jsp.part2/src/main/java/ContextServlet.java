

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextServlet")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ContextServlet() {
        super();
        
    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=getServletContext();
		Enumeration<String> params=context.getInitParameterNames();
		
		String paramsStr="";		
		PrintWriter out=response.getWriter();
		while(params.hasMoreElements()) {
			paramsStr=params.nextElement();
			out.println(paramsStr+" : "+context.getInitParameter(paramsStr));
		}

	}
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doGet(request, response);
	}

}
