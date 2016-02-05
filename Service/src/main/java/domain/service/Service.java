package domain.service;

import java.io.Serializable;

public class Service implements Serializable{
	protected Long id;
	protected String title;
	protected String description;
	protected String category; 
	
	
public Service() {
}
	
	public Service(String title, String description, String categorie) {
	    
		this.title = title;
		this.description = description;
		this.category = categorie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return category;
	}
	public void setCategorie(String categorie) {
		this.category = categorie;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

	@Override
	public String toString() {
		return "Service [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category;
	}
	
	
	
}
