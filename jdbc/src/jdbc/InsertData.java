package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
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
	String query="insert into employee(name,age,address,salary) values(?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, "Harry");
		ps.setInt(2, 32);
		ps.setString(3, "New York");
		ps.setDouble(4, 2300);
		ps.executeUpdate();
		System.out.println("Insert successful");
	} catch (SQLException e) {
		System.out.println("Insert Fail\n"+e.getMessage());
	}
	}	
}

