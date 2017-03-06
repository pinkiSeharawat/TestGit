package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.PersonalInfo;
import com.util.MyDButil;

public class NewPersonalInfoDBAccess {

    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=MyDButil.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from personalinfo where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
	
		public String checkByName(String name) throws SQLException
		{
			
		
			Connection con=MyDButil.getConnection();
			
		    PreparedStatement statement=con.prepareStatement("select count(*) from personalinfo where customerName=?");
		    
		    statement.setString(1, name);
		    
		    String count=null;
		    
		    ResultSet rs=statement.executeQuery();
		    while (rs.next())
		    {
		    	count=rs.getString(1);
		    	//System.out.println(rs.getInt(0)+" "+rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
		    }
		   
		    MyDButil.closeConnection(con);
			
			return count;
			
		}

		
		public PersonalInfo getDetailsByName(String name)
		{
			Connection con =MyDButil.getConnection();
			PersonalInfo personal=new PersonalInfo();
			try {
				PreparedStatement ps=con.prepareStatement("select * from PersonalInfo where customerName=?");
				ps.setString(1,name);
			    ResultSet rs=ps.executeQuery();
			    
			    while(rs.next())
			    {
			    	
			    personal.setCustomerEmailId(rs.getString(3));
			    personal.setMobileNumber(rs.getString(4));
			    personal.setAddress(rs.getString(5));
			    personal.setModelNumber(rs.getString(6));
			    personal.setSerialNumber(rs.getString(7));
			    personal.setPurchaseDate(rs.getDate(8));
			    personal.setWarrentyDate(rs.getDate(9));
			    personal.setDamagePartName(rs.getString(10));
			    personal.setNumberOfTimesRepaired(rs.getInt(11));
			    personal.setAMC(rs.getDouble(12));
			    personal.setTotalAmount(rs.getDouble(13));
			    
			    }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			 MyDButil.closeConnection(con);
			return personal;
			
			
		}
		
		   public static List<PersonalInfo> getAllCustomer(){  
			   
			   Connection con =MyDButil.getConnection();
		        List<PersonalInfo> list=new ArrayList<PersonalInfo>();  
		        
		          
		        try{  
		            PreparedStatement ps=con.prepareStatement("select * from PersonalInfo");  
		            ResultSet rs=ps.executeQuery();  
		            while(rs.next()){ 
		            	PersonalInfo personal=new PersonalInfo();
		            	
		            	personal.setCustomerEmailId(rs.getString(3));
		 			    personal.setMobileNumber(rs.getString(4));
		 			    personal.setAddress(rs.getString(5));
		 			    personal.setModelNumber(rs.getString(6));
		 			    personal.setSerialNumber(rs.getString(7));
		 			    personal.setPurchaseDate(rs.getDate(8));
		 			    personal.setWarrentyDate(rs.getDate(9));
		 			    personal.setDamagePartName(rs.getString(10));
		 			    personal.setNumberOfTimesRepaired(rs.getInt(11));
		 			    personal.setAMC(rs.getDouble(12));
		 			    personal.setTotalAmount(rs.getDouble(13));
		 			    
		            }  
		            con.close();  
		        }catch(Exception e){e.printStackTrace();}  
		          
		        return list;  
		    } 

	}


