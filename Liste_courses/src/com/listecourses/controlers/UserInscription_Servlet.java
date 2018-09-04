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
public class UserInscription_Servlet extends HttpServlet {
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
    public UserInscription_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lancement de l'init pour instancier
		if(!User_Dao.isInit){
			User_Dao.Init();
		}
		
		//recuperation des données dans le front
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		//Pour donner des values en dur
		email = "celine@gmail.com"; password = "azer"; lastName = "celine"; firstName = "mercadier";
		
		//verif email
		if(email != "" && email !=null && isValidateEmail(email)){
			//TODO finir verif autres champs
			if(password != "" && lastName != "" && firstName !=""){
				User_ newUser = new User_(email, password, lastName, firstName, true);
				//AJOUT DANS LA LISTE DE USER (ou inscription en DB)
				User_Dao.userList.add(newUser);
				session.setAttribute("lastName", newUser.getLastName());
				session.setAttribute("user", newUser);
				session.setAttribute("test", "le test");
				System.out.println((String) session.getAttribute("test"));
				
				//redirection pour recup toutes les listes de courses de l'user en corus
				response.sendRedirect("UserShoppingListsServlet");
			}	
		}else {
			String message = "erreur sur un des champs";
			System.out.println(message);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
