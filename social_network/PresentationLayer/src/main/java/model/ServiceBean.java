package model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


/**
 * 
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * This class is a domain object acting as a backing bean to the service adding form holding its relative data provided via form submission. 
 * We will annotate the properties(with validation annotations) which we want to be validated.
 *
 */
public class ServiceBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(min=3, max=20)
	private String categorie;
	
	@NotEmpty
	@Size(min=3, max=30)
	private String title;
	
	private Date debut; 
	private Date fin; 

	@Size(min=3, max=100)
	private String desc;

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	

}
