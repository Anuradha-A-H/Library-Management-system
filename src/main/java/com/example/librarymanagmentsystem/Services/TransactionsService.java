package com.example.librarymanagmentsystem.Services;

import com.example.librarymanagmentsystem.Entities.Book;
import com.example.librarymanagmentsystem.Entities.LibraryCard;
import com.example.librarymanagmentsystem.Entities.Transactions;
import com.example.librarymanagmentsystem.Enums.TransactionStatus;
import com.example.librarymanagmentsystem.Enums.TransactionType;
import com.example.librarymanagmentsystem.Repository.BookRepository;
import com.example.librarymanagmentsystem.Repository.CardRepository;
import com.example.librarymanagmentsystem.Repository.StudentRepository;
import com.example.librarymanagmentsystem.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionsService {

    @Autowired
    private CardRepository cardRepo;
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private TransactionsRepository transactionRepo;
    public String IssueBook(Integer cardId, Integer bookId)throws Exception{


        Transactions transaction  = new Transactions();
        transaction.setTransactionType(TransactionType.ISSUED);
        transaction.setStatus(TransactionStatus.ONGOING);

        Optional<Book> optionalbook = bookRepo.findById(bookId);
        if(optionalbook.isEmpty())
        {
            throw new Exception("Invalid bookId");
        }
        Book book = optionalbook.get();
        Optional<LibraryCard> optionalcard = cardRepo.findById(cardId);
        if(optionalcard.isEmpty())
        {
            throw new Exception("Invalid cardId");
        }
        LibraryCard card = optionalcard.get();

        // check for availability

        if(book.isAvilabelStatus() == Boolean.FALSE)
        {
            transaction.setStatus(TransactionStatus.FAILURE);
            transaction = transactionRepo.save(transaction);
            throw new Exception("Book with the bookId is InValid");
        }

        if(card.getNoOfBookIssued()>= LibraryCard.MAX_NO_OF_ALLOWED_BOOKS)
        {
            transaction.setStatus(TransactionStatus.FAILURE);
            transaction = transactionRepo.save(transaction);
            throw new Exception("You have reached the max limit");
        }


        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setTransactionType(TransactionType.ISSUED);


        //update card and book status
        book.setAvilabelStatus(Boolean.FALSE);

        card.setNoOfBookIssued(card.getNoOfBookIssued()+1);

        transaction = transactionRepo.save(transaction);
        return "transaction saved "+transaction.getTransactionsId();
    }
}
