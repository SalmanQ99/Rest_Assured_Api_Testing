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

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
