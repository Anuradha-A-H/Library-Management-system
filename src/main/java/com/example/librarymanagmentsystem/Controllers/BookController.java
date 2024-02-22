package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.RequestDocs.AddAuthorRequest;
import com.example.librarymanagmentsystem.RequestDocs.AddBookRequest;
import com.example.librarymanagmentsystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
