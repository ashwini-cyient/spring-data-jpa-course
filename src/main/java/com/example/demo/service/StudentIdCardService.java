package com.example.demo.service;

import com.example.demo.entitiy.Student;
import com.example.demo.entitiy.StudentIdCard;
import com.example.demo.repository.StudentIdCardRepository;

import java.util.List;
import java.util.Optional;

public class StudentIdCardService {

    private final StudentIdCardRepository _studentIdCardRepository;
    private FakerUtil _fakerUtil;

    public StudentIdCardService(StudentIdCardRepository studentIdCardRepository, FakerUtil fakerUtil) {
        this._studentIdCardRepository = studentIdCardRepository;
        this._fakerUtil = fakerUtil;
    }

    public void createStudentCard() {
        Student student = this._fakerUtil.createFakeStudent();

        StudentIdCard studentIdCard = new StudentIdCard("12355678910", student);

        this._studentIdCardRepository.save(studentIdCard);

    }

    public void findStudentIdCards() {
        Iterable<StudentIdCard> studentIdCards = this._studentIdCardRepository.findAll();
        studentIdCards.forEach((studentIdCard) -> System.out.println(studentIdCard));

    }

    public void findStudentIdCardById(Long id){
        this._studentIdCardRepository.findById(id).ifPresent(System.out::println);

    }


}
