package storeprocedureassign;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class createSP {
    public static Connection con = null;

    static {
        con = MyConnection.getConnection();
    }

    public static void main(String[] args) {
        try {
            CallableStatement cst = con.prepareCall("{call add_customer(?,?,?,?)}");
            cst.setInt(1, 11);
            cst.setString(2, "Su");
            cst.setString(3, "Itly");
            cst.setBigDecimal(4, new BigDecimal("1231.4"));

            int result = cst.executeUpdate();
            if (result > 0) {
                System.out.println("Successfully Inserted");
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
