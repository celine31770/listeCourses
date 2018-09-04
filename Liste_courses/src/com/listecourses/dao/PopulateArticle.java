package com.listecourses.dao;

import java.util.*;

import com.listecourses.models.Article;
import com.listecourses.models.ShoppingList;
import com.listecourses.models.User_;

public class PopulateArticle {
	private static int articleSize;
	
	private static List<User_> ul = (List<User_>) Collections.synchronizedList(PopulateUser_.generateUserList());
	
	// M�thode pour g�n�rer une liste d'articles
	public static ArrayList<Article> generateArticleList() {
		
		Article article1 = new Article("Banane", ul.get(0));
		Article article2 = new Article("Chocolat", ul.get(0));
		Article article3 = new Article("Pomme", ul.get(1));
		Article article4 = new Article("Carotte", ul.get(1));
		
		ArrayList listArticle = new ArrayList<Article>();
		listArticle.add(article1);
		listArticle.add(article2);
		listArticle.add(article3);
		listArticle.add(article4);
	
		articleSize = listArticle.size();
		
		return listArticle;
	}
	
	
	// M�thode pour r�cup�rer une liste de courses associ� � un user
	public static ShoppingList generateShoppingList(User_ user){
		
		// On r�cup�re la liste de tous les articles
		ArrayList<Article> a = generateArticleList();
		
		// On cr�� une shoppingList (liste d'articles)
		ShoppingList shoppingList = new ShoppingList("Liste de " + user.getFirstName());
		
		// ON boucle sur la liste d'articles pour le user
		for(int i = 0; i < articleSize ; i++) {

			// Si le user de l'article plac� � l'index i 
			// correspond au user envoy� en param�tre (user)
			if(user.equals(a.get(i).getUser())) {
				// On ajoute l'article � la liste de l'utilisateur
				shoppingList.addArticle(a.get(i));	
			}else {
				System.out.println("Aucun article trouv�");
				return shoppingList;
			}	
		} // Fin de la boucle	
		
		// On renvoie la liste d'article correspondant � un user
		return shoppingList;

	} // Fin m�thode generateShoppingList()

}
