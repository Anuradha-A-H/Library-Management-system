package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;


}
