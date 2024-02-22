package com.example.librarymanagmentsystem.Services;


import com.example.librarymanagmentsystem.Entities.Author;
import com.example.librarymanagmentsystem.Repository.AuthorRepository;
import com.example.librarymanagmentsystem.RequestDocs.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
