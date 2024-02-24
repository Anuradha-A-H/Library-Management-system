package com.example.librarymanagmentsystem.Services;


import com.example.librarymanagmentsystem.Entities.Author;
import com.example.librarymanagmentsystem.Entities.Book;
import com.example.librarymanagmentsystem.Repository.AuthorRepository;
import com.example.librarymanagmentsystem.RequestDocs.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;


    public String addAuthor(AddAuthorRequest addAuthReq)
    {
        Author addAuth = new Author(addAuthReq.getAuthorName(),addAuthReq.getEmailId(),addAuthReq.getAge());
        authorRepo.save(addAuth);
        return "Author with authordetails is added successfully";

    }

    public Author getAuthor(Integer authId) throws Exception
    {
        Optional<Author> authDetails = authorRepo.findById(authId);

        if(authDetails.isEmpty())
        {
            throw new Exception("Invalid AuthorId");
        }

        return authDetails.get();
    }
}
