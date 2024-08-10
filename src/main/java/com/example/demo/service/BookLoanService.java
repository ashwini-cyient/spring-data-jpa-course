package com.example.demo.service;

import com.example.demo.entitiy.Book;
import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentRepository;

public class BookLoanService {

    private StudentRepository _studentRepository;
    public BookLoanService(StudentRepository studentRepository){
        this._studentRepository = studentRepository;
    }

    public void issueBook(Book book, Student student) {

        student.assignBook(book);
        this._studentRepository.save(student);

    }


}
