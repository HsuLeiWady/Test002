package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UpdateData {
	public static Connection myConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}catch (SQLException e) {
			System.out.println("Database not found");
	}
		return con;			
	}
	public static void main (String [] args) {
	Connection con=myConnection();
	String query="update employee set salary=? where id=?";
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, 2500);
		ps.setInt(2, 5);
		ps.executeUpdate();
		System.out.println("Update successful");
	} catch (SQLException e) {
		System.out.println("Update Fail\n"+e.getMessage());
	}
	}	
}

