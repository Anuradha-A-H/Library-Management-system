package com.example.librarymanagmentsystem.Services;

import com.example.librarymanagmentsystem.Entities.LibraryCard;
import com.example.librarymanagmentsystem.Entities.Student;
import com.example.librarymanagmentsystem.Enums.CardStatus;
import com.example.librarymanagmentsystem.Repository.CardRepository;
import com.example.librarymanagmentsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private StudentRepository studentRepo;

    public String getFreshCard(){

        LibraryCard newCard = new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBookIssued(0);

        LibraryCard savedCard = cardRepo.save(newCard);

        return "Node card with Card No "+savedCard.getCardId()+" has beed generated";


    }

    public String associateCardAndStudent(Integer cardId, Integer studentId) throws Exception
    {
        Optional<LibraryCard> optionalLibraryCard = cardRepo.findById(cardId);

        if(optionalLibraryCard.isEmpty())
        {
            throw new Exception("Invalid card Id Exception");
        }

        LibraryCard libraryCard = optionalLibraryCard.get();

        Optional<Student> optionalStudent = studentRepo.findById(studentId);

        if(optionalStudent.isEmpty())
        {
            throw new Exception("Invalid Student Id Exception");
        }
        Student student  = optionalStudent.get();

        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);
        libraryCard.setNoOfBookIssued(0);
        cardRepo.save(libraryCard);
        return "card with cardId "+ cardId+" and student id"+studentId;
    }


    public LibraryCard getCard(Integer cardId)throws Exception{
            Optional<LibraryCard> cardDtails = cardRepo.findById(cardId);
            if(cardDtails.isEmpty())
            {
                throw new Exception("Invalid card Id");
            }
            LibraryCard card = cardDtails.get();

            Integer CardId = card.getCardId();

            Student studentDetail = card.getStudent();

            Integer studentId = studentDetail.getStudentId();

            return card;
    }
}
