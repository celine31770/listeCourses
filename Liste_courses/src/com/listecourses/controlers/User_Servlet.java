package com.listecourses.controlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.listecourses.dao.User_Dao;
import com.listecourses.models.User_;

//import com.formation.controlers.String;

/**
 * Servlet implementation class User_Servlet
 */
@WebServlet("/User_Servlet")
public class User_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //regex verif email 
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	//method verif email regex
	public boolean isValidateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
	}


	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation des données dans le front
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		
		//verif email
		if(email != "" && email.isEmpty() && email !=null && isValidateEmail(email)){
			//TODO finir verif autres champs
			if(password != "" && lastName != "" && firstName !=""){
				User_ newUser = new User_(email, password, lastName, firstName, true);
				//AJOUT DANS LA LISTE DE USER (ou inscription en DB)
				User_Dao.userList.add(newUser);
				//création de la session
				HttpSession session = request.getSession(true);
				//Boolean isConnect = (Boolean) session.getAttribute("connected");
				
				session.setAttribute("connected", true);
				session.setAttribute("lastName", newUser.getLastName());
				session.setAttribute("user", newUser);
				//redirection pour recup toutes les listes de courses de l'user en corus
				response.sendRedirect("UserShoppingListsServlet");
			}	
		}else {
			String message = "erreur sur un des champs";
		}
		
		
		
	/*	if(login.equals("admin") && password.equals("admin")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("connected", true);
			session.setAttribute("log", login);
			response.sendRedirect("SearchServlet");
		}else {
			String message = "erreur sur login / mdp";
			request.setAttribute("mess", message);
			doGet(request, response);
		}*/
		
	}

}
