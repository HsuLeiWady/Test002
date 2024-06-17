package studentmanagementsystem.persistant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import studentmanagementsystem.persistant.DTO.CourseRequestDTO;
import studentmanagementsystem.persistant.DTO.StudentRequestDTO;

public class CourseDAO {
public static Connection con = null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	//insert
	
	public static int addCourse(CourseRequestDTO CourseDTO) {
		int result = 0;
		String sql = "INSERT INTO student(id,name) VALUES(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, CourseDTO.getId());
			ps.setString(2, CourseDTO.getName());
				
			result = ps.executeUpdate();
			if (con != null) {
	            con.close(); }
			
		}catch(SQLException e){
			System.out.println("Insert error!!! "+e);
		}
		return result;
	}
}
