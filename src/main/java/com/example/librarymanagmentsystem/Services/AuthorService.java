package com.example.librarymanagmentsystem.Services;


import com.example.librarymanagmentsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepo;
}
