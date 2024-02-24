package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Entities.Book;
import com.example.librarymanagmentsystem.RequestDocs.AddAuthorRequest;
import com.example.librarymanagmentsystem.RequestDocs.AddBookRequest;
import com.example.librarymanagmentsystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody AddBookRequest addBookReq)
    {
        String result = bookService.addBook(addBookReq);
        return result;
    }

    @GetMapping("/getBook")
    public ResponseEntity getBook(@RequestParam("bookId")Integer bookId)throws Exception
    {
        try{
            Book bookDetails = bookService.getBook(bookId);

            return new ResponseEntity(bookDetails, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
