package bussiness.service_layer;

import java.util.Collection;

import domain.person.Person;

public interface IUser {

	/**
     * Adds a person to database.
     * @param person The person to add
     * @param password The password for p
     * @throws Exception if a person with the same email address already exists or
     * a database access error occurs
     */
    public boolean addUser (Person person, String password);

    /**
     * Returns the list of all persons in databse.
     * @return The list of all persons in databse as an instance of java.util.CollectionPerson.
     * @throws Exception if a database access error occurs
     */
    public Collection<Person> getAllUsers ();

    /**
     * Returns the list of all email addresses in database.
     * @return The list of all logins in this database as an instance of java.util.CollectionString.
     * @throws Exception if a database access error occurs
     */
    public Collection<String> getAllEmails ();

    /**
     * Returns the person with a given email.
     * @param email The email to search for
     * @return The person with the given email
     * @throws Exception if no person with the given email exists or a database access error
     * occurs
     */
    public Person getPerson (String email);

    /**
     * Decides whether a given couple (email,password) exists in the list.
     * @return false if either there is no person with the given email in the
     * list or the password is incorrect, true otherwise
     * @throws Exception if a database access error occurs
     */
    public boolean isValidUser (String email, String password);

    /**
     * Decides whether a person with a given email exists in the list.
     * @return true is the list contains a person with the given email,
     * false otherwise
     * @throws Exception if a database access error occurs
     */
    public boolean userExists (String email);

    // "U" operations

    /**
     * Updates the person associated to a given email address in the database.
     * Given that the email address is part of an instance of Person, this method
     * may be safely used to change the email address itself.
     * @param email The email address of the person to update
     * @param person An instance of Person to store in place of the existing one
     * @throws Exception if no person is currently associated to the given email address,
     * or the new instance has an email address which already exists in the database, or a
     * database access error occurs
     */
    public boolean updateUser (String email, Person person);

    /**
     * Updates a person's password in the database.
     * @param email The email address of the person whose password to update
     * @param password The new password for the person
     * @throws Exception if no person is currently associated to the given email address
     * or a database access error occurs
     */
    public boolean updateUserPassword (String email, String password);

    // "D" operations

    /**
     * Removes the person with a given email address from this database.
     * @param email The email address of the person to remove
     * @throws Exception if no person is currently associated to the given email address
     * or a database access error occurs
     */
    public boolean deleteUser (String email);
}
