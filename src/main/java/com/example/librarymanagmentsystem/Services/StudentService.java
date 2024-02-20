package com.example.librarymanagmentsystem.Services;

import com.example.librarymanagmentsystem.Entities.Student;
import com.example.librarymanagmentsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public String addStudent(Student student)
    {
       studentRepo.save(student);
       return " Student has been added to Table";
    }
}
