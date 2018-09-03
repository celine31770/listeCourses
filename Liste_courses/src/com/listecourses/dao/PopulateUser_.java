package com.listecourses.dao;

import java.util.ArrayList;

import com.listecourses.models.ShoppingList;
import com.listecourses.models.User_;

public class PopulateUser_ {
	
	// Methode qui va cr�er une liste de users
	public static ArrayList<User_> generateUserList() {
		User_ user1 = new User_("laurene.labios@orange.fr", "coucou", "Labios", "Laur�ne", true);
		User_ user2 = new User_("celinemercadier@gmail.com", "coucou", "Mercadier", "C�line", true);
		User_ user3 = new User_("adriano.bertolini@gmail.com", "coucou", "Bertolini", "Adriano", false);
		User_ user4 = new User_("zouheir@gmail.com", "coucou", "Yadir", "Zouheir", false);
		
		ArrayList listUser = new ArrayList<User_>();
		listUser.add(user1);
		listUser.add(user2);
		listUser.add(user3);
		listUser.add(user4);
		
		return listUser;
	} // Fin generateUserList

}
