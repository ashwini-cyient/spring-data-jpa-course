package com.example.demo.service;

import com.example.demo.entitiy.LibraryCard;
import com.example.demo.entitiy.Student;
import com.example.demo.repository.LibraryCardRepository;

import java.util.UUID;


public class LibraryCardService {

    private final LibraryCardRepository _libraryCardRepository;

    public LibraryCardService(LibraryCardRepository libraryCardRepository) {
        this._libraryCardRepository = libraryCardRepository;
    }



    public void issueLibraryCard(Student student) {
        if(student == null){
            return;
        }
        LibraryCard libraryCard = new LibraryCard(UUID.randomUUID().toString(), student);
        this._libraryCardRepository.save(libraryCard);
        System.out.println("---id card issued-----"+ libraryCard);

    }

    public void findStudentIdCards() {
        Iterable<LibraryCard> studentIdCards = this._libraryCardRepository.findAll();
        studentIdCards.forEach((libraryCard) -> System.out.println(libraryCard));

    }

    public void findStudentIdCardById(Long id){
        this._libraryCardRepository.findById(id).ifPresent(System.out::println);

    }


    /*updateIdCardDetails(Student student, IdCard idCard)
    deactivateIdCard(Long idCardId)
    getIdCardDetails(Long idCardId)
    getAllIdCards()
    replaceLostIdCard(Student student)*/








}
