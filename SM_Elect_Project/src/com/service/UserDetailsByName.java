package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.PersonalInfo;
import com.DAO.NewPersonalInfoDBAccess;
import com.DAO.PersonalInfoDBAccess;

/**
 * Servlet implementation class UserDetailsByName
 */
public class UserDetailsByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();  
		String name=request.getParameter("userName");
		
        NewPersonalInfoDBAccess personalInfoDB= new NewPersonalInfoDBAccess();
        PersonalInfo personalInf=new PersonalInfo();
        personalInf=personalInfoDB.getDetailsByName(name);
        
        session.setAttribute("personalInf", personalInf);
        response.sendRedirect("SearchByName.jsp");
        
	}

}
