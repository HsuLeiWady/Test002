package studentmanagementsystem.persistant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentmanagementsystem.persistant.DTO.StudentRequestDTO;
import studentmanagementsystem.persistant.DTO.StudentResponseDTO;

public class StudentDAO {
public static Connection con = null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	//insert
	
	public static int addStudent(StudentRequestDTO StudentDTO) {
		int result = 0;
		String sql = "INSERT INTO student(code,name,phno,dob,gender,education,attend) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, StudentDTO.getCode());
			ps.setString(2, StudentDTO.getName());
			ps.setString(3, StudentDTO.getPhno());
			ps.setString(4, StudentDTO.getDob());
			ps.setString(5, StudentDTO.getGender());
			ps.setString(6, StudentDTO.getEducation());
			ps.setString(7, StudentDTO.getAttend());
			
			result = ps.executeUpdate();
			if (con != null) {
	            con.close(); }
			
		}catch(SQLException e){
			System.out.println("Insert error!!! "+e);
		}
		return result;
	}
}