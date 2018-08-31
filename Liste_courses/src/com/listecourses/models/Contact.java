package com.listecourses.models;
import javax.persistence.*;


@Entity 
@Table(name="Contact")
public class Contact {
	
	@Column(name="user_id",updatable=false,nullable=false)
	private User userId;
	
	@Column(name="contact_id",updatable=false,nullable=false)
	private User contactId;
	
	@Column(name="name")
	private String name;
	

	// GETTERS ET SETTERS ***************
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public User getContactId() {
		return contactId;
	}

	public void setContactId(User contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
