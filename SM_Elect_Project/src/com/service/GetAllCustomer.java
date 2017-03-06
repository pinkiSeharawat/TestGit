package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PersonalInfo;
import com.DAO.NewPersonalInfoDBAccess;

/**
 * Servlet implementation class GetAllCustomer
 */
@WebServlet("/GetAllCustomer")
public class GetAllCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

    
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       response.setContentType("text/html");  
	       PrintWriter out=response.getWriter();  
	       
	       HttpSession session=request.getSession();
	       
	       System.out.println("Get All User");  
	       
	       List<PersonalInfo> list=NewPersonalInfoDBAccess.getAllCustomer(); 
	       
	       out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Id</th><th>Customer Name</th><th>Customer EmailId</th>"
	        		+ "<th>MobileNumber</th><th>Address</th><th>ModelNumber</th>"
	        		+ "<th>SerialNumber</th><th>Purchase Date</th><th>Warrenty Date</th>"
	        		+ "<th>DamagePartName</th><th>NumberOfTimesRepaired</th><th>AMC</th>"
	        		+ "<th>Total Amount</th></tr>");  
	                   
	       
	      // session.setAttribute("list", list);
	       
	       for(PersonalInfo personal:list)
	       {
	    	   System.out.println("Get all User second");
	    	   
	    	   out.print("<tr><td>"+personal.getId()+"</td><td>"+personal.getCustomerName()+"</td><td>"
	    	   +personal.getCustomerEmailId()+"</td><td>"+personal.getMobileNumber()+"</td><td>"
	    			   +personal.getAddress()+ "</td><td>" +personal.getModelNumber()+"</td><td>"+personal.getSerialNumber()+
	    			   "</td><td>"+personal.getPurchaseDate()+"</td><td>"+personal.getWarrentyDate()+"</td><td>"+
	    			   "</td><td>"+personal.getDamagePartName()+"</td><td>"+personal.getNumberOfTimesRepaired()+"</td><td>"+
	    			   personal.getAMC()+"</td><td>"+personal.getTotalAmount()+"</td></tr>");
	    	   
	       }
	       
	       out.print("</table>");  
	          
	        out.close(); 
	}

}
