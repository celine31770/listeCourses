package com.listecourses.controlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listecourses.dao.PopulateArticle;
import com.listecourses.dao.User_Dao;
import com.listecourses.models.Article;
import com.listecourses.models.ShoppingList;
import com.listecourses.models.User_;

/**
 * Servlet implementation class UserShoppingListsServlet
 */
@WebServlet("/UserShoppingListsServlet")
public class UserShoppingListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserShoppingListsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String ln = (String) session.getAttribute("lastName");
		User_ userEnvoye = (User_)session.getAttribute("user");
		
		User_Dao.Init();
		ArrayList<ShoppingList> listeDeListeDeShopping = userEnvoye.getListeCourse();
		for(ShoppingList shopLists: listeDeListeDeShopping){
			System.out.println(shopLists.getName());
		}

		response.getWriter().append("email : ").append(userEnvoye.getEmail());
		response.getWriter().append("List courses : ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
