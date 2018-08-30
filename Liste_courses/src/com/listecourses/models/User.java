package com.listecourses.models;
import java.util.Date;
import javax.persistence.*;


// Ca dit a hibernate que ça correspond à une table de BDD
@Entity 
@Table(name="User")
public class User  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",updatable=false,nullable=false,unique=true)
	private long id;
	
	@Column(name="email",nullable=false,unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="lastName")
	private String last_name;
	
	@Column(name="firstName")
	private String first_name;
	
	// Date d'inscription ou date du jour de l'invitation
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCreation",updatable=false, nullable=false)
	private Date date_creation;
	
	// Pour savoir si le compte est actif ou pas 
	@Column(name="isValid",nullable=false,columnDefinition = "boolean default false")
	private boolean is_valid;
	
	
	// CONSTRUCTEUR 
	// pour création du compte au moment d'une invitation
	public User(String email) {
		super();
		this.email = email;
	}
	
	// pour création du compte lors de l'inscription
	public User(String email, String password, String last_name, String first_name, boolean is_valid) {
		super();
		this.email = email;
		this.password = password;
		this.last_name = last_name;
		this.first_name = first_name;
		this.is_valid = is_valid;
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Date getDate_creation() {
		return date_creation;
	}


	public boolean getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(boolean is_valid) {
		this.is_valid = is_valid;
	}
	
	
	// CUSTOM METHODS *************
	// ****************************
	
	// Au moment de la création de l'enregistrement
	// Si on voulait exécuter qlqe chose au moment de l'update, ce serait @PreUpdate
	@PrePersist
	private void onCreate() {
		date_creation = new Date();
	}
	
	
	

}
