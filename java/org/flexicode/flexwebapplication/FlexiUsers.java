package org.flexicode.flexwebapplication;

import java.util.Date;

public class FlexiUsers {

    /**
     * A simple construction of a flexi user that takes
     * no argument or attribute of the flexi user into
     * account before creating the user.
     * This constructor is created for the main reason
     * of acquiring a user from the database.
     */
    public FlexiUsers(){}


    public FlexiUsers(
            String username,
            String password,
            String email,
            String country,
            Date dateOfBirth,
            String firstName,
            String middleName,
            String lastName,
            String language) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public FlexiUsers(
            String username,
            String password,
            String email,
            String country,
            String firstName,
            String middleName,
            String lastName,
            String language) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    protected int userId;
    public void setUserId(int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return userId;
    }
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getLanguage(){
        return language;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    private String username;
    private String password;
    private String email;
    private Date dateOfBirth;
    private String firstName;
    private String middleName;
    private String country;
    private String lastName;
    private String language;

    @Override
    public String toString() {
        return  "User ID = " + userId +
                "\nUsername : " + username +
                "\nFirst Name : " + firstName +
                "\nMiddle Name : " + middleName +
                "\nLast Name : " + lastName +
                "\nEmail : " + email +
                "\nCountry : " + country +
                "\nD.O.B : " + dateOfBirth +
                "\nLanguage : " + language;
    }

}
