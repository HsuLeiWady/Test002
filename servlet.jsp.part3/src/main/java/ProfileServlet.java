

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		Cookie ck[]=request.getCookies();
		request.getRequestDispatcher("cookies_link.jsp").include(request, response);
		
		PrintWriter out=response.getWriter();
		if(ck!=null) {
			out.print(ck.length+"<br>");
			for(Cookie c: ck) {
				out.print(c.getName()+" - "+c.getValue()+"<br>");
			}
		}else {
			out.print("Please login first");
			response.sendRedirect("cookies_login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
