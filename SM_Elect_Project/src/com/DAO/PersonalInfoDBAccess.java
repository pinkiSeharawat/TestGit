package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.PersonalInfo;
import com.util.MyDButil;

public class PersonalInfoDBAccess  {
	
	public int getId() throws SQLException
	{
		ResultSet rs=null;
		int id=0;
		Connection con=MyDButil.getConnection();
		
	    PreparedStatement statement=con.prepareStatement("select max(id) from personalinfo");
	    
	    System.out.println("start");
	     rs=statement.executeQuery();
	    while (rs.next())
	    {
	    	System.out.println("end");
	    	id=rs.getInt(1);
	    	//System.out.println(rs.getInt(0)+" "+rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
	    }
	    id=id+1;
	    MyDButil.closeConnection(con);
		
		return id;
		
	}
	public int checkId(int id) throws SQLException
	{
		ResultSet rs=null;
	
		Connection con=MyDButil.getConnection();
		
	    PreparedStatement statement=con.prepareStatement("select count(*) from personalinfo where id=?");
	    
	    statement.setInt(1, id);
	    
	    int count=0;
	    
	    rs=statement.executeQuery();
	    while (rs.next())
	    {
	    	count=rs.getInt(1);
	    	//System.out.println(rs.getInt(0)+" "+rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
	    }
	   
	    MyDButil.closeConnection(con);
		
		return count;
		
	}
	
	public void insertPersonalDetails(PersonalInfo personalInfo)
	
	{
		PreparedStatement ps=null;
		Connection con=MyDButil.getConnection();
		
		try {
			
			
			 ps=con.prepareStatement("insert into personalInfo values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		    
			ps.setInt(1,personalInfo.getId());
			ps.setString(2,personalInfo.getCustomerName());
		    ps.setString(3,personalInfo.getCustomerEmailId());
		    ps.setString(4,personalInfo.getMobileNumber());
		    ps.setString(5,personalInfo.getAddress());
		    ps.setString(6,personalInfo.getModelNumber());
		    ps.setString(7,personalInfo.getSerialNumber());
		    ps.setDate(8,(Date.valueOf(personalInfo.getPurchaseDate().toString())));
		    ps.setDate(9,(Date.valueOf(personalInfo.getWarrentyDate().toString())));
		    ps.setString(10,personalInfo.getDamagePartName());
		    ps.setInt(11,personalInfo.getNumberOfTimesRepaired());
		    ps.setDouble(12,personalInfo.getAMC());
		    ps.setDouble(13,personalInfo.getTotalAmount());
		    
		    System.out.println("ps: "+ps.toString());
		    
			ps.execute();
			  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		    MyDButil.closeConnection(con) ;
	}
	
	public PersonalInfo getDetails(int iD)
	{
		ResultSet rs=null;
		Connection con =MyDButil.getConnection();
		PersonalInfo personal=new PersonalInfo();
		try {
			PreparedStatement ps=con.prepareStatement("select * from PersonalInfo where id=?");
			ps.setInt(1,iD);
		     rs=ps.executeQuery();
		    
		    while(rs.next())
		    {
		    	
		    personal.setCustomerName(rs.getString(2));
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

}
