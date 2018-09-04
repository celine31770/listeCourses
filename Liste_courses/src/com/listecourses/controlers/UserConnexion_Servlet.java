package com.listecourses.controlers;

import java.io.IOException;
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

/**
 * Servlet implementation class UserConnexion_Servlet
 */
@WebServlet("/UserConnexion_Servlet")
public class UserConnexion_Servlet extends HttpServlet {
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
    public UserConnexion_Servlet() {
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

		//Pour donner des values en dur
		email = "laurene.labios@orange.fr"; password = "cou";
		String adresse = "";
		
		
		//verif email
		if(email != "" && email !=null && isValidateEmail(email)){
				//VERIFIER DANS LA LISTE DE USER S'IL EXISTE (ou SELECT en DB)
				for(User_ u:User_Dao.userList){
					if(u.getEmail() == email && u.getPassword() == password){//si email et password sont identique à un user
						HttpSession session = request.getSession();
						session.setAttribute("user", u);
						//redirection pour recup toutes les listes de courses de l'user en corus
						//response.sendRedirect("UserShoppingListsServlet");
						adresse = "UserShoppingListsServlet";
						break;
					}else{
						System.out.println("inconnu au bataillon");
						//response.sendRedirect("http://google.com");
						adresse = "http://google.com";
					}
				}
			response.sendRedirect(adresse);
		}else {
			String message = "erreur sur un des champs";
			System.out.println(message);
		}
	}//fin du doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
