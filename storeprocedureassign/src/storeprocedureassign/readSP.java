package storeprocedureassign;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class readSP {

		public static Connection con = null;
		static {
				con = MyConnection.getConnection();
		}
		public static void main(String[] args) {
			List<customer> listCust=new ArrayList<customer>();
				try {
					CallableStatement cst = con.prepareCall("{call get_all_customers()}");
					 ResultSet rs=cst.executeQuery();
					 while(rs.next()) {
						customer cust=new customer();		
						cust.setId(rs.getInt(1));
						cust.setName(rs.getString(2));
						cust.setAddress(rs.getString(4));
						cust.setSalary(rs.getDouble(5));
						listCust.add(cust);
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
