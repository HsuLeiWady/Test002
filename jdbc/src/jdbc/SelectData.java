package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SelectData {
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
	String query="select from  employee where id=?";
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,1);	
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println("Id "+rs.getInt("id"));
			System.out.println("Name "+rs.getString("name"));
			System.out.println("Age "+rs.getInt("age"));
			System.out.println("Address "+rs.getString("address"));
			System.out.println("Salary "+rs.getDouble("salary"));			
		}
	} catch (SQLException e) {
		System.out.println("Select Fail\n"+e.getMessage());
	}
	}	
}
