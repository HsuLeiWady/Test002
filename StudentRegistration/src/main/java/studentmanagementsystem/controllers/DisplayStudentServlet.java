 package studentmanagementsystem.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.models.StudentBean;
import studentmanagementsystem.persistant.DAO.StudentDAO;
import studentmanagementsystem.persistant.DTO.StudentResponseDTO;

/**
 * Servlet implementation class DisplayStudentServlet
 */
@WebServlet("/DisplayStudentServlet")
public class DisplayStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO studentDAO = new StudentDAO();
		List<StudentBean> students = new ArrayList<StudentBean>();
		
		List<StudentResponseDTO> studentDTOs = studentDAO.getAllstudents();
		for(StudentResponseDTO dto:studentDTOs) {
			StudentBean bean = new StudentBean();
			bean.setCode(dto.getCode());
			bean.setName(dto.getName());
			bean.setPhno(dto.getPhno());
			bean.setDob(dto.getDob());
			bean.setGender(dto.getGender());
			bean.setEducation(dto.getEducation());
			bean.setAttend(dto.getAttend());
			bean.setCourse_id(dto.getCourse_id());		
			students.add(bean);
		}
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("displaystudent.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
