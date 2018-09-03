package com.listecourses.dao;

import java.util.ArrayList;

import com.listecourses.models.*;
import com.listecourses.models.User_;

public class User_Dao implements IAbstractDao<User_> {
	
	// On créé la liste de user en appelant la méthode generateUserList
	public ArrayList<User_> userList = PopulateUser_.generateUserList();
	
	
	
	public static void Init() {
		ArrayList<Contact> listContact = PopulateContact.generateContactList();
		
		// On va boucler sur tous les contacts dans listContact
		for(Contact c:listContact) {
			// On va comparer les users
			//userList.
			//c.getUserId()
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
