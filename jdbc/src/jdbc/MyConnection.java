package jdbc;
import java.sql.*;
public class MyConnection {
	public static void main (String [] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				System.out.println("Connecting....");
		} catch (ClassNotFoundException e) {
   			System.out.println("Driver class not found");
		} catch (SQLException e) {
			System.out.println("Database not found");
		}
	}
}
