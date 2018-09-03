package com.listecourses.models;
import javax.persistence.*;


@Entity 
@Table(name="Contact")
public class Contact {
	
	@Column(name="user_id",updatable=false,nullable=false)
	private User_ userId;
	
	@Column(name="contact_id",updatable=false,nullable=false)
	private User_ contactId;
	
	@Column(name="name")
	private String name;
	

	// GETTERS ET SETTERS ***************
	public User_ getUserId() {
		return userId;
	}

	public void setUserId(User_ userId) {
		this.userId = userId;
	}

	public User_ getContactId() {
		return contactId;
	}

	public void setContactId(User_ contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
