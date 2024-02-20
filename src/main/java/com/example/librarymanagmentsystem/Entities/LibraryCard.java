package com.example.librarymanagmentsystem.Entities;

import com.example.librarymanagmentsystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="library_card")
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    private int noOfCardIssued;

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

    public int getNoOfCardIssued() {
        return noOfCardIssued;
    }

    public void setNoOfCardIssued(int noOfCardIssued) {
        this.noOfCardIssued = noOfCardIssued;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JoinColumn
    @OneToOne
    private Student student;
}
