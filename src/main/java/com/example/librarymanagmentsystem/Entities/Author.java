package com.example.librarymanagmentsystem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.sql.Date;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private int authorAge;
    private String authorName;
    @Column(unique = true, nullable = false)
    private String emailId;

    private int age;

    private int noOfBooksWritten;


    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();


    public Author(String authorName, String emailId, int age,List<Book>  bookList) {
        this.authorName = authorName;
        this.emailId = emailId;
        this.age = age;
        this.bookList = bookList;
    }
    public Author(String authorName, String emailId, int age) {
        this.authorName = authorName;
        this.emailId = emailId;
        this.age = age;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
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

    public List<Book>  getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


}
