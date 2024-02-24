package com.example.librarymanagmentsystem.Entities;

import com.example.librarymanagmentsystem.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(unique = true)
    private String bookName;

    @Enumerated(value = EnumType.STRING)
    private Genre bookGenre;
    private int noOfPages;
    private int price;

    private Date publishDate;

    private boolean avilabelStatus;

    @JsonIgnore
    @JoinColumn(name = "emailId")
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    public List<Transactions> transactionList = new ArrayList<>();

    public Book(String bookName, Genre bookGenre, int noOfPages, int price, Date publishDate) {
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.noOfPages = noOfPages;
        this.price = price;
        this.publishDate = publishDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Genre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isAvilabelStatus() {
        return avilabelStatus;
    }

    public void setAvilabelStatus(boolean avilabelStatus) {
        this.avilabelStatus = avilabelStatus;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
