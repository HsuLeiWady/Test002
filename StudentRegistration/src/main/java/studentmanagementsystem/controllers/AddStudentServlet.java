package studentmanagementsystem.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.models.StudentBean;
import studentmanagementsystem.persistant.DAO.StudentDAO;
import studentmanagementsystem.persistant.DTO.StudentRequestDTO;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO studentDAO = new StudentDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addstudent.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("code").equals("") || 
				request.getParameter("name").equals("") ||
				request.getParameter("phno").equals("") ||
				request.getParameter("dob").equals("") ||
				request.getParameter("gender").equals("") ||
				request.getParameter("education").equals("") ||
				request.getParameter("attend").equals("")) {
				
				StudentBean student = new StudentBean();
				student.setCode(request.getParameter("code"));
				student.setName(request.getParameter("name"));
				student.setPhno(request.getParameter("phno"));
				student.setDob(request.getParameter("dob"));
				student.setGender(request.getParameter("gender"));
				student.setEducation(request.getParameter("education"));
				student.setAttend(request.getParameter("attend"));
								
				request.setAttribute("student", student);
				request.setAttribute("error", "Fields can't be blank!!!");
				request.getRequestDispatcher("addstudent.jsp").forward(request, response);
			}else {
				
				StudentBean student = new StudentBean();
				student.setCode(request.getParameter("code"));
				student.setName(request.getParameter("name"));
				student.setPhno(request.getParameter("phno"));
				student.setDob(request.getParameter("dob"));
				student.setGender(request.getParameter("gender"));
				student.setEducation(request.getParameter("education"));
				student.setAttend(request.getParameter("attend"));
				
				
				StudentRequestDTO dto = new StudentRequestDTO();
				dto.setCode(student.getCode());
				dto.setName(student.getName());
				dto.setPhno(student.getPhno());
				dto.setDob(student.getDob());
				dto.setGender(student.getGender());
				dto.setEducation(student.getEducation());
				dto.setAttend(student.getAttend());
				
				
				StudentDAO.addStudent(dto);
				
				response.sendRedirect("student");
			}
	}
}
