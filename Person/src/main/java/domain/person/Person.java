package domain.person;

import java.io.Serializable;

/**
 * A class for representing persons, with a name, a first name, and an email address.
 * @author Amani LAHBIB and mykyta KHARAIM, Caen Basse-Normandie University, France
 */

public class Person implements Serializable{
	
    /** The person's name. */
    protected String name;

    /** The person's first name. */
    protected String firstName;

    /** The person's email address. */
    protected String email;

    /**
     * Builds a new person.
     * @param name The person's name
     * @param firstName The person's first name
     * @param email The person's email address
     */
    public Person (String name, String firstName, String email) {
        this.name=name;
        this.firstName=firstName;
        this.email=email;
    }

    /**
     * Returns the person's name.
     * @return The person's name
     */
    public String getName () {
        return this.name;
    }

    /**
     * Returns the person's first name.
     * @return The person's first name.
     */
    public String getFirstName () {
        return this.firstName;
    }

    /**
     * Returns the person's email address.
     * @return The person's email address
     */
    public String getEmail () {
        return this.email;
    }
    

    /**
     * Change person's name.
     * @param name The person's name
    */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Change person's firstName.
     * @param firstName The person's first name
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
     * Change person's email adress.
     * @param email The person's email address
     */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
     * Returns a representation of this person as a string.
     * @return A representation of this person as a string
     */
    public String toString () {
        return "person "+this.firstName+" "+this.name+" (email "+this.email+")";
    }

}
