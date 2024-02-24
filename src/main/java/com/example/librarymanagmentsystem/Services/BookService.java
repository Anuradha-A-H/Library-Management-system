package com.example.librarymanagmentsystem.Services;

import com.example.librarymanagmentsystem.Entities.Author;
import com.example.librarymanagmentsystem.Entities.Book;
import com.example.librarymanagmentsystem.Repository.AuthorRepository;
import com.example.librarymanagmentsystem.Repository.BookRepository;
import com.example.librarymanagmentsystem.RequestDocs.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepository authRepo;

    public String addBook(AddBookRequest bookReq)
    {

        //get authidand make entity
        Integer authId = bookReq.getAuthorId();
//        System.out.println(authId);
        Author authdetails = authRepo.findById(bookReq.getAuthorId()).get();

//        if(!authdetails.isEmpty())
//        {
//            Author authdetail = authdetails.get();
//        }
        //make book entity
        Book newBook = new Book(bookReq.getBookName(),bookReq.getBookGenre(),bookReq.getNoOfPages(),bookReq.getPrice(),bookReq.getPublishDate());
////
////       //set Foreighkey for book
////        //adding book to auth entity
        newBook.setAuthor(authdetails);
////
        List<Book> bookl = authdetails.getBookList();
        bookl.add(newBook);
        authdetails.setBookList(bookl);
////        //set Foreighkey for auth
////        //for the auth add the book in the book list
//        //bidirectional mapping
        authdetails.setNoOfBooksWritten(authdetails.getNoOfBooksWritten()+1);
////
////
////        //set parent class
        authRepo.save(authdetails);

        return "done successfully";
    }

    public Book getBook(Integer bookId)throws Exception
    {
        Optional<Book> bookDetails = bookRepo.findById(bookId);
        if(bookDetails.isEmpty())
        {
            throw new Exception("Invalid Id");
        }
        return bookDetails.get();
    }
}
