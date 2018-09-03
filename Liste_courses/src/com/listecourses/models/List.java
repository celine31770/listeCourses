package com.listecourses.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="list")
public class List {
	
	//VARIABLES	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",updatable=false,nullable=false,unique=true)
	private long id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	// Pour récupérer la liste des articles
	private ArrayList<Article> listeArticle;
	
	// CONSTRUCTEUR

	public List(String name) {
		this.name = name;
	}
	
	//GETTER / SETTER

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Article> getListeArticle() {
		return listeArticle;
	}

	public void setListeArticle(ArrayList<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	
	// CUSTOM METHODS *************
	// ****************************
	
	// Ajouter un article de la liste
	public void addArticle(Article e) {
		this.listeArticle.add(e);
	}
	
	// Supprimer un article de la liste
	public void deleteArticle(Article e) {
		this.listeArticle.remove(e);
	}
	
	
	

}
