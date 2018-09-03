package com.listecourses.models;
import javax.persistence.*;


@Entity 
@Table(name="Contact")
public class Contact {
	
	@Column(name="user_id",updatable=false,nullable=false)
	private User_ user;
	
	@Column(name="contact_id",updatable=false,nullable=false)
	private User_ contact;
	
	@Column(name="name")
	private String name;
	
	
	
	// CONSTRUCTEUR
	public Contact(User_ user, User_ contact) {
		// Si les utilisateurs sont différents
		if(!user.equals(contact)) {
		this.user = user;
		this.contact = contact;
		}else {
			System.out.println("Vous êtes le contact invité");
		}
	}

	// GETTERS ET SETTERS ***************
	public User_ getUserId() {
		return user;
	}

	public void setUserId(User_ userId) {
		this.user = userId;
	}

	public User_ getContactId() {
		return contact;
	}

	public void setContactId(User_ contactId) {
		this.contact = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
