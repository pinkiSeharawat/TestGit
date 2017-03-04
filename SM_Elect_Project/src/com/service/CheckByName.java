package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.PersonalInfo;
import com.DAO.NewPersonalInfoDBAccess;
import com.DAO.PersonalInfoDBAccess;

/**
 * Servlet implementation class CheckByName
 */
public class CheckByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		NewPersonalInfoDBAccess dbAccess=new NewPersonalInfoDBAccess();
		
		String name=request.getParameter("userName");
		
		@SuppressWarnings("unchecked")
		List<PersonalInfo> list=(List<PersonalInfo>) dbAccess.getDetailsByName(name);
		  request.setAttribute("list", list);
		    if(list.size()>0)
		{
			
		
					
					UserDetailsByName userDetail = new UserDetailsByName();
					userDetail.doPost(request, response);
		}
		else
				{
					response.sendRedirect("UserNotFound.jsp");
				}
			
		}
	}

		
	
	



