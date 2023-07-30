package com.sw.api.test.dto;

public class PostAuthorDTO {
    private int idBook;
    private String firstName;
    private String lastName;

    public PostAuthorDTO(int idBook, String firstName, String lastName) {
        this.idBook = idBook;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * Gets the book id of activity
     * @return the book id of the activity
     */
    public int getIdBook() {
        return idBook;
    }
    /**
     * Sets the book id of activity
     */
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    /**
     * Gets the firstName of activity
     * @return the firstName of the activity
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the firstname of activity
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Gets the lastName of activity
     * @return the lastName of the activity
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the lastname of activity
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
