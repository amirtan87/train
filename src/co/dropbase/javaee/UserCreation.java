package co.dropbase.javaee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCreation {

	 // JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

   //  Database credentials
	static final String USER = "root";
	static final String PASS = "pvrdbadmin";
   
	public void addUser (String username, String password) {
	Connection conn = null;
	Statement stmt = null;
	try{
      //STEP 2: Register JDBC driver
		Class.forName("com.mysql.jdbc.Driver");

	//STEP 3: Open a connection
	System.out.println("Connecting to a selected database...");
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	System.out.println("Connected database successfully...");
  
	//STEP 4: Execute a query
	System.out.println("Inserting table in given database...");
	stmt = conn.createStatement();
  
	PreparedStatement USER_PW = conn.prepareStatement
	      ("insert into USER_PW(username, password) values(?,?)");
    USER_PW.setString(1,username);
    USER_PW.setString(2, password);
	USER_PW.executeUpdate();
    System.out.println("Inserted in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample