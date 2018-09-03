package com.listecourses.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.listecourses.models.Contact;
import com.listecourses.models.User_;

public class PopulateContact {
	
	private static List<User_> ul = (List<User_>) Collections.synchronizedList(PopulateUser_.generateUserList());
	
	
	// Methode qui va créer une liste de contact
	public static ArrayList<Contact> generateContactList() {
		Contact contact1 = new Contact(ul.get(0), ul.get(1));
		Contact contact2 = new Contact(ul.get(0), ul.get(2));
		Contact contact3 = new Contact(ul.get(1), ul.get(0));
		Contact contact4 = new Contact(ul.get(1), ul.get(2));
		
		ArrayList listContact = new ArrayList<Contact>();
		listContact.add(contact1);
		listContact.add(contact2);
		listContact.add(contact3);
		listContact.add(contact4);
		
		return listContact;
	}
}
