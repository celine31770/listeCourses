package com.listecourses.dao;

import java.util.ArrayList;

import com.listecourses.models.*;
import com.listecourses.models.User_;

public class User_Dao implements IAbstractDao<User_> {
	
	// On créé la liste de user en appelant la méthode generateUserList
	public static  ArrayList<User_> userList = PopulateUser_.generateUserList();
	
	
	
	public static void Init() {
		ArrayList<Contact> listContact = PopulateContact.generateContactList();
		
		// On va boucler sur tous les users dans userList
		for(User_ u: userList){ // pour chaque user de la liste
			for(Contact c:listContact){  // on parcours tous les contacts
				//s'il y a correspondance entre le user de la userList et le userId dans la listContact
				if(u.equals(c.getUserId())){// On va comparer les users
					//on ajoute le contact à la liste du user en cours
					u.addContact(c);
				}
			}
		}

	}
	
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
