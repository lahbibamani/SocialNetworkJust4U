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
 * This class is a domain object acting as a backing bean to the user inscription form holding its relative data provided via form submission. 
 * We will annotate the properties(with validation annotations) which we want to be validated.
 *
 */
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Size(min=3, max=30)
	private String lastname;
	
	@NotEmpty
	@Size(min=3, max=30)
	private String firstname;
	
	private Date birthDate; 

	@NotEmpty
	private String phone;
	
	private String type;
	
	@NotEmpty
	@Size(min=3, max=20)
	private String pwd;
 
    @NotEmpty
    private String gender;
 
    @Email @NotEmpty
    private String email;
 
    @NotEmpty
    private String adress;
 
    @NotEmpty
    private String country;
	
	private String city;
	
	private String img;

    public String getName() {
		return lastname;
	}

	public void setName(String name) {
		this.lastname = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	

}
