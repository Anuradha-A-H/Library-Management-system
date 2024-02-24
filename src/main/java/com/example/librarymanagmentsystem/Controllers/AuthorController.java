package com.example.librarymanagmentsystem.Controllers;


import com.example.librarymanagmentsystem.Entities.Author;
import com.example.librarymanagmentsystem.Entities.Book;
import com.example.librarymanagmentsystem.RequestDocs.AddAuthorRequest;
import com.example.librarymanagmentsystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAuthor")
    public ResponseEntity getAuthor(@RequestParam("authId")Integer authId)throws Exception
    {
        try{
            Author authDetails = authservice.getAuthor(authId);
            List<Book> booki = authDetails.getBookList();
            for(Book b : booki)
            {
                System.out.println(b.getBookName());
            }
            return  new ResponseEntity(authDetails,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
