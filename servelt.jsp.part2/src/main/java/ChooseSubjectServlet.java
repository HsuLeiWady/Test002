

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChooseSubjectServlet")
public class ChooseSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ChooseSubjectServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] subject= {"Java", "C++", "Python", "JavaScript"};
	    request.getSession().setAttribute("subject", subject);
	    request.getRequestDispatcher("/WEB-INF/views/chooseSubject.jsp").forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
