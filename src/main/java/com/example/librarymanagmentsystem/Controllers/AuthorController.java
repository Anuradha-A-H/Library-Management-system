package com.example.librarymanagmentsystem.Controllers;


import com.example.librarymanagmentsystem.RequestDocs.AddAuthorRequest;
import com.example.librarymanagmentsystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthorController {

    @Autowired
    private AuthorService authservice;
    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AddAuthorRequest authReq)
    {
        String result = authservice.addAuthor(authReq);
        return result;

    }
}
