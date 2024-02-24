package com.example.librarymanagmentsystem.Entities;

import com.example.librarymanagmentsystem.Enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="library_card")
public class LibraryCard {
    public static final Integer MAX_NO_OF_ALLOWED_BOOKS = 8;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    private int noOfBookIssued;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public int getNoOfBookIssued() {
        return noOfBookIssued;
    }

    public void setNoOfBookIssued(int noOfBookIssued) {
        this.noOfBookIssued = noOfBookIssued;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JsonIgnore
    @JoinColumn
    @OneToOne
    private Student student;

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    public List<Transactions> transactionList = new ArrayList<>();
}
