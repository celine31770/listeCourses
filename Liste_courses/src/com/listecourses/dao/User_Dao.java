package com.listecourses.dao;

import java.util.ArrayList;

import com.listecourses.models.*;
import com.listecourses.models.User_;

public class User_Dao implements IAbstractDao<User_> {
	
	// On créé la liste de user en appelant la méthode generateUserList
	public static ArrayList<User_> userList = PopulateUser_.generateUserList();
	
	
	//pour peupler les listes des users (à faire dés le début de l'app)
	public static void Init() {
		ArrayList<Contact> listContact = PopulateContact.generateContactList();
		// AJOUT DES CONTACTS DANS LA LISTE DE CONTACTS DU USER EN COURS
		// On va boucler sur tous les users dans userList
		for(User_ u: userList){ // pour chaque user de la liste
			for(Contact c:listContact){  // on parcours tous les contacts
				//s'il y a correspondance entre le user de la userList et le userId dans la listContact
				if(u.equals(c.getUserId())){// On va comparer les users
					//on ajoute le contact à la liste du user en cours
					u.addContact(c);
				}
			}

			
			
	
			ArrayList<Article> listArticle = PopulateArticle.generateArticleList();
			// AJOUT DES ARTICLES DANS LA LISTE D'ARTICLES DU USER EN COURS
			for(Article article:listArticle){ // pour chaque article 
				if(u.equals(article.getUser())){ // si le user propriétaire de l'article est le user en cours
					u.addArticle(article); //on ajoute l'article dans la liste d'article de l'user
				}
			}
			// AJOUT DES SHOPPING LISTE DANS LA LISTE  DU USER EN COURS
						//creation de la shopping list de l'user en mettant les articles associé a la shoppingList
			
			ShoppingList sl = PopulateArticle.generateShoppingList(u);
			u.addListCourse(sl);
		
			
		}//fin du for

	}//fin de methode
	
	@Override
	public void create(User_ entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User_ update(User_ entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User_ entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User_ findObject(User_ entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
