package com.listecourses.models;
import java.util.*;
import javax.persistence.*;


// Ca dit a hibernate que ça correspond à une table de BDD
@Entity 
@Table(name="User")
public class User_  {
	
	//VARIABLES	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",updatable=false,nullable=false,unique=true)
	private long id;
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	// Date d'inscription ou date du jour de l'invitation
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_creation",updatable=false, nullable=false)
	private Date dateCreation;
	
	// Pour savoir si le compte est actif ou pas 
	@Column(name="is_valid",nullable=false,columnDefinition = "boolean default false")
	private boolean isValid;
	
	// Pour récupérer la liste des contacts
	private ArrayList<Contact> listeContact;
	
	// Pour récupérer la liste des listes de courses
	private ArrayList<ShoppingList> listeCourse;
	
	
	// CONSTRUCTEUR 
	// pour création du compte au moment d'une invitation
	public User_(String email) {
		super();
		this.email = email;
	}
	
	// pour création du compte lors de l'inscription
	public User_(String email, String password, String lastName, String firstName, boolean isValid) {
		super();
		this.email = email;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.isValid = isValid;
	}

	private String machin;
	
	public String getMachin() {
		return machin;
	}

	public void setMachin(String machin) {
		this.machin = machin;
	}
	

	@Override
	public String toString() {
		return "User_ [id=" + id + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User_ other = (User_) obj;
		if (id != other.id)
			return false;
		return true;
	}

	// GETTERS ET SETTERS ***************
	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean is_valid) {
		this.isValid = is_valid;
	}
	
	public ArrayList<Contact> getListeContact() {
		return listeContact;
	}

	public void setListeContact(ArrayList<Contact> listeContact) {
		this.listeContact = listeContact;
	}
	
	public ArrayList<ShoppingList> getListeCourse() {
		return listeCourse;
	}

	public void setListeCourse(ArrayList<ShoppingList> listeCourse) {
		this.listeCourse = listeCourse;
	}
	
	
	// CUSTOM METHODS *************
	// ****************************


	// Au moment de la création de l'enregistrement
	// Si on voulait exécuter qlqe chose au moment de l'update, ce serait @PreUpdate
	@PrePersist
	private void onCreate() {
		dateCreation = new Date();
	}
	
	// Ajouter une liste de course
	public void addListCourse(ShoppingList e) {
		this.listeCourse.add(e);
	}
	
	// Supprimer une liste de course
	public void deleteListCourse(ShoppingList e) {
		this.listeCourse.remove(e);
	}
	
	// Ajouter un contact à la liste de Contact
	public void addContact(Contact e) {
		this.listeContact.add(e);
	}
	
	// Supprimer un contact de la liste Contact
	public void deleteContact(Contact e) {
		this.listeContact.remove(e);
	}
	
	

}// Fin class User
