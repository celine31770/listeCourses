package com.listecourses.dao;

import java.util.*;

import com.listecourses.models.Article;
import com.listecourses.models.ShoppingList;
import com.listecourses.models.User_;

public class PopulateArticle {
	private static int articleSize;
	
	private static List<User_> ul = (List<User_>) Collections.synchronizedList(PopulateUser_.generateUserList());
	
	// Méthode pour générer une liste d'articles
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
	
	
	// Méthode pour récupérer une liste de courses associé à un user
	public static ShoppingList generateShoppingList(User_ user){
		
		// On récupère la liste de tous les articles
		ArrayList<Article> a = generateArticleList();
		
		// On créé une shoppingList (liste d'articles)
		ShoppingList shoppingList = new ShoppingList("Liste de " + user.getFirstName());
		
		// ON boucle sur la liste d'articles pour le user
		for(int i = 0; i < articleSize ; i++) {

			// Si le user de l'article placé à l'index i 
			// correspond au user envoyé en paramètre (user)
			if(user.equals(a.get(i).getUser())) {
				// On ajoute l'article à la liste de l'utilisateur
				shoppingList.addArticle(a.get(i));	
			}else {
				System.out.println("Aucun article trouvé");
				return shoppingList;
			}	
		} // Fin de la boucle	
		
		// On renvoie la liste d'article correspondant à un user
		return shoppingList;

	} // Fin méthode generateShoppingList()

}
