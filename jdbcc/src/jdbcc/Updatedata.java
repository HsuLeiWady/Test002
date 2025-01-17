package jdbcc;
import java.sql.*;
public class Updatedata {
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
		ps.setDouble(1, 2500);
		ps.setInt(2, 2);
		ps.executeUpdate();
		System.out.println("Update successful");
	} catch (SQLException e) {
		System.out.println("Update Fail\n"+e.getMessage());
	}
	}	
}
