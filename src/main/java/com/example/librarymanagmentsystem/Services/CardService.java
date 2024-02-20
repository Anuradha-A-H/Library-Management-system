package com.example.librarymanagmentsystem.Services;

import com.example.librarymanagmentsystem.Entities.LibraryCard;
import com.example.librarymanagmentsystem.Enums.CardStatus;
import com.example.librarymanagmentsystem.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepo;

    public String getFreshCard(){

        LibraryCard newCard = new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfCardIssued(0);

        LibraryCard savedCard = cardRepo.save(newCard);

        return "Node card with Card No "+savedCard.getCardId()+" has beed generated";


    }
}
