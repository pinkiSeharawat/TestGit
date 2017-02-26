package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDButil {
	 
		@SuppressWarnings("finally")
		public static Connection getConnection() {
			 
			 Connection con=null;
		try {
		      Class.forName("com.mysql.jdbc.Driver");
		      String url="jdbc:mysql://localhost:3306/mysql";
		      con=DriverManager.getConnection(url,"root","root");
		    }
		
		catch (Exception e)
		    {
			System.out.println(e);
			System.out.println("EXCEPTION OCCURED");
		    }
		
		finally {
	       
			return con;
		         
		         }
		
		 }
		 public static void closeConnection(Connection dbConnection) {
		        try {
		            dbConnection.close();
		            dbConnection=null;
		            } catch (SQLException e) {
		             
		            e.printStackTrace();
		            }
		 
		    }

}
