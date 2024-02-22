package com.example.librarymanagmentsystem.RequestDocs;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuthorRequest {
    private Integer authorId;
    private String authorName;
    private String emailId;
    private int age;
    private int noOfBooksWritten;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNoOfBooksWritten() {
        return noOfBooksWritten;
    }

    public void setNoOfBooksWritten(int noOfBooksWritten) {
        this.noOfBooksWritten = noOfBooksWritten;
    }
}
