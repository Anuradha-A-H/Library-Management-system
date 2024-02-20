package com.example.librarymanagmentsystem.Services;

import com.example.librarymanagmentsystem.Entities.Student;
import com.example.librarymanagmentsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public String addStudent(Student student)
    {
       studentRepo.save(student);
       return " Student has been added to Table";
    }

    public Student findStudentById(Integer studentId) throws Exception{
        Optional<Student> optionLStudent = studentRepo.findById(studentId);

        if(optionLStudent.isEmpty()){
            throw new Exception("Student Id Is Invalid");
        }
        Student student = optionLStudent.get();

        return student;
    }

}
