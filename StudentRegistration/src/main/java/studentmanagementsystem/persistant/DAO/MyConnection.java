package studentmanagementsystem.persistant.DAO;
import java.sql.*;

public class MyConnection {
  
  static Connection con=null;
  public static Connection getConnection() {
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
    //  String db="testingdb";
    //  String username="root";
    //  String password="root";
    //  con=DriverManager.getConnection(db,username,password);
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");
    } catch (ClassNotFoundException e) {
      System.out.println("Driver not found " + e);
    }catch(SQLException e){
      System.out.println("sql exception "+ e);
    }
    return con;
  }
}