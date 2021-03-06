package com.listecourses.models;
import java.util.*;
import javax.persistence.*;


// Ca dit a hibernate que �a correspond � une table de BDD
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
	
	// Pour r�cup�rer la liste des contacts
	private ArrayList<Contact> listeContact = new ArrayList<Contact>();
	
	// Pour r�cup�rer la liste des listes de courses
	private ArrayList<ShoppingList> listeCourse = new ArrayList<ShoppingList>();

	// Pour r�cup�rer la liste des listes de courses
	private ArrayList<Article> listeArticle = new ArrayList<Article>();
	
	// CONSTRUCTEUR 
	// pour cr�ation du compte au moment d'une invitation
	public User_(String email) {
		super();
		this.email = email;
	}
	
	// pour cr�ation du compte lors de l'inscription
	public User_(String email, String password, String lastName, String firstName, boolean isValid) {
		super();
		this.email = email;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.isValid = isValid;
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

	public ArrayList<Article> getListeArticle() {
		return listeArticle;
	}

	public void setListeArticle(ArrayList<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	
	
	// CUSTOM METHODS *************
	// ****************************


	// Au moment de la cr�ation de l'enregistrement
	// Si on voulait ex�cuter qlqe chose au moment de l'update, ce serait @PreUpdate
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
	
	// Ajouter un contact � la liste de Contact
	public void addContact(Contact e) {
		this.listeContact.add(e);
	}
	
	// Supprimer un contact de la liste Contact
	public void deleteContact(Contact e) {
		this.listeContact.remove(e);
	}
	
	// Ajouter un article � la liste de Contact
	public void addArticle(Article e) {
		this.listeArticle.add(e);
	}
	
	// Supprimer un article de la liste Contact
	public void deleteArticle(Article e) {
		this.listeArticle.remove(e);
	}
	
	

}// Fin class User
