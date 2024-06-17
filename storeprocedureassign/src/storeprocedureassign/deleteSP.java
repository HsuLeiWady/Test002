package storeprocedureassign;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class deleteSP {
	public static Connection con = null;
	static {
	con = MyConnection.getConnection();
	}
	public static void main(String[] args) {
		try {
			CallableStatement cst = con.prepareCall("{call delete_customer(?)}");
			 cst.setInt(1,8);
			 int result=cst.executeUpdate();	
			 if(result>0) {
				System.out.println("Successfully Delete");
			}
		    cst.close();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}