package com.example.librarymanagmentsystem.Entities;

import com.example.librarymanagmentsystem.Enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
}
