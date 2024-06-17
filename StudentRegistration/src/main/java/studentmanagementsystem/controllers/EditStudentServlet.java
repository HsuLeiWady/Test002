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
import studentmanagementsystem.persistant.DTO.StudentResponseDTO;

/**
 * Servlet implementation class EditStudentServlet
 */
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO dao = new StudentDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String code = request.getParameter("code");
			
			StudentBean viewModel = new StudentBean();
			
			StudentResponseDTO dto = dao.getStudentByCode(code);
			viewModel.setCode(dto.getCode());
			viewModel.setName(dto.getName());
			viewModel.setPhno(dto.getPhno());
			viewModel.setDob(dto.getDob());
			viewModel.setGender(dto.getGender());
			viewModel.setEducation(dto.getEducation());
			viewModel.setAttend(dto.getAttend());
			viewModel.setCourse_id(dto.getCourse_id());
			
			
			request.setAttribute("student", viewModel);
			
			request.getRequestDispatcher("editstudent.jsp").forward(request, response);		
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("code").equals("") || 
				request.getParameter("name").equals("") ||
				request.getParameter("phno").equals("") ||
				request.getParameter("dob").equals("")||
			    request.getParameter("gender").equals("") ||
			    request.getParameter("education").equals("") || 	
			    request.getParameter("attend").equals("") ||
				request.getParameter("course_id").equals("")) {	
				
				StudentBean student = new StudentBean();
					student.setCode(request.getParameter("code"));
					student.setName(request.getParameter("name"));
					student.setPhno(request.getParameter("phno"));
					student.setDob(request.getParameter("dob"));
					student.setGender(request.getParameter("gender"));
					student.setEducation(request.getParameter("education"));
					student.setAttend(request.getParameter("attend"));
					student.setCourse_id(Integer.parseInt(request.getParameter("attend")));
					
					request.setAttribute("student", student);
					request.setAttribute("error", "Fields can't be blank!!!");
					request.getRequestDispatcher("editstudent.jsp").forward(request, response);
				}else {
					
					StudentBean student = new StudentBean();
					student.setCode(request.getParameter("code"));
					student.setName(request.getParameter("name"));
					student.setPhno(request.getParameter("phno"));
					student.setDob(request.getParameter("dob"));
					student.setGender(request.getParameter("gender"));
					student.setEducation(request.getParameter("education"));
					student.setAttend(request.getParameter("attend"));
					student.setCourse_id(Integer.parseInt(request.getParameter("attend")));
					
					
					StudentRequestDTO dto = new StudentRequestDTO();
					dto.setCode(student.getCode());
					dto.setName(student.getName());
					dto.setPhno(student.getPhno());
					dto.setDob(student.getDob());
					dto.setGender(student.getGender());
					dto.setEducation(student.getEducation());
					dto.setAttend(student.getAttend());
					dto.setCourse_id(student.getCourse_id());
							
					dao.editStudent(dto);
					
					response.sendRedirect("students");
				}		
		}
	}
