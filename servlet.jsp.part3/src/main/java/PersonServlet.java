

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public PersonServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		foo.Person myPerson=new foo.Person();
		myPerson.setName("Swe Swe");
		
		foo.Person friend=new foo.Person();
		friend.setName("Mae Tin");
		
		foo.Employeee e1=new foo.Employeee();
		e1.setId(100);
		e1.setName("Moe Moe");
		e1.setFriend(friend);
		
		request.setAttribute("p",myPerson);//request
		request.getSession().setAttribute("e", e1);//session
		request.getServletContext().setAttribute("f",friend);//application
		
		request.getRequestDispatcher("type.jsp").forward(request, response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
