package storeprocedureassignment;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;
public class customerManagement {


	 private ArrayList<Customer> customers;
	 

	 public customerManagement() {
	  customers = new ArrayList<>();
	  
	 }

	 public static void main(String[] args) {
		 customerManagement system = new customerManagement();
	  system.runMenu();
	 }

	 private void runMenu() {
	  Scanner s = new Scanner(System.in);
	  int choice;

	  do {
	   System.out.println("Hi!Welcome form Our Customer Management System..");
	   System.out.println("This is a Menu\n");
	   System.out.println("(1) Add New Customer");
	   System.out.println("(2) Update Customer");
	   System.out.println("(3) Delete Customer");
	   System.out.println("(4) Get Customer Name By Address");
	   System.out.println("(5) Get Customer Level");
	   System.out.println("(6) Exit");
	   System.out.print("Enter the number: ");

	   choice = s.nextInt();
	   s.nextLine();

	   switch (choice) {
	   case 1:
	    addNewCustomer();
	    break;
	   case 2:
	    updateCustomer();
	    break; 
	   case 3:
	    deleteCustomer();
	    break;
	   case 4:
	    getCustomerNameByAddress();
	    break;
	   case 5:
	    getCustomerlvl();
	    break;
	   case 0:
	    System.out.println("Exiting the program!");
	    break;
	   default:
	    System.out.println("Invalid number. Please try again.");
	   }
	  } while (choice != 0);
	 }
	 
	 //addCutomer
	 private static void addNewCustomer() {
	         Scanner s = new Scanner(System.in);
	         System.out.println("Add new Customer\n");
	         System.out.print("Enter Customer id: ");
	         int id = s.nextInt();
	         s.nextLine(); 
	         System.out.print("Enter Customer name: ");
	         String name = s.nextLine();
	         System.out.print("Enter Customer address: ");
	         String address = s.nextLine();
	         System.out.print("Enter Customer salary: ");
	         double salary = s.nextDouble();

	         Customer cst = new Customer();
	         cst.setId(id);
	         cst.setName(name);
	         cst.setAddress(address);
	         cst.setSalary(salary);
	         
	         addCustomerToDatabase(cst);

	         System.out.println("Customer Data added successfully");
	     }
	   private static void addCustomerToDatabase(Customer customer) {
	         Connection conn = MyConnection.getConnection();
	         try {
	             CallableStatement cst = conn.prepareCall("call add_customer(?,?,?,?)");
	             cst.setInt(1, customer.getId());
	             cst.setString(2, customer.getName());
	             cst.setString(3, customer.getAddress());
	             cst.setDouble(4, customer.getSalary());
	             int result = cst.executeUpdate();
	             if(result > 0) {
	                 System.out.println("Successfully Inserted!");
	             }
	             cst.close();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
	   
	   //updateCustomer
	   private static void updateCustomer() {
	         Scanner s = new Scanner(System.in);
	         System.out.println("Update Customer\n");
	         System.out.print("Enter Customer id: ");
	         int id = s.nextInt();
	         s.nextLine();  
	         System.out.print("Enter new Customer address: ");
	         String address = s.nextLine();

	         updateCustomerInDatabase(id, address);

	         System.out.println("Customer Data updated successfully");
	     }
	     private static void updateCustomerInDatabase(int id, String address) {
	         Connection conn = MyConnection.getConnection();
	         try {
	             CallableStatement cst = conn.prepareCall("call update_customer(?,?)");
	             cst.setInt(1, id);
	             cst.setString(2, address);

	         int result = cst.executeUpdate();
             if (result > 0) {
                 System.out.println("Successfully Updated!");
             }
             cst.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
     //deleteCustomer
     private static void deleteCustomer() {
         Scanner s = new Scanner(System.in);
         System.out.println("Delete Customer\n");
         System.out.print("Enter Customer id: ");
         int id = s.nextInt();

         deleteCustomerFromDatabase(id);

         System.out.println("Customer Data deleted successfully...");
     }
     private static void deleteCustomerFromDatabase(int id) {
         Connection conn = MyConnection.getConnection();
         try {
             CallableStatement cst = conn.prepareCall("call delete_customer(?)");
             cst.setInt(1, id);
             int result = cst.executeUpdate();
             if (result > 0) {
                 System.out.println("Successfully Deleted!");
             }
             cst.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
     //ReadAddress
     private static void getCustomerNameByAddress() {
         Scanner s = new Scanner(System.in);
         System.out.println("Get Customer Names by Address\n");
         System.out.print("Enter Customer address: ");
         String address = s.nextLine();

         getCustomerNamesFromDatabase(address);
     }
     private static void getCustomerNamesFromDatabase(String address) {
         Connection conn = MyConnection.getConnection();
         try {
             CallableStatement cst = conn.prepareCall("call get_customers_by_cursor_excep_handler(?, ?)");
             cst.setString(1, address);
             cst.registerOutParameter(2, Types.VARCHAR);
             cst.execute();
             String nameList = cst.getString(2);
             System.out.println("Customer Names: " + nameList);
             cst.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
     
     //getCustomerlvl
  private void getCustomerlvl() {
   Scanner s = new Scanner(System.in);
         System.out.println("Get Customer Level\n");
         System.out.print("Enter Customer Id: ");
         int id = s.nextInt();
         
         getCustomerlevelFromDatabase(id);

  }
  private void getCustomerlevelFromDatabase(int id) {
   Connection conn = MyConnection.getConnection();
         try {
             CallableStatement cst = conn.prepareCall("call get_customer_level1(?, ?)");
             cst.setInt(1, id);
             cst.registerOutParameter(2, Types.VARCHAR);
             cst.execute();
             String level = cst.getString(2);
             System.out.println("Customer Level: " + level);
             cst.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
