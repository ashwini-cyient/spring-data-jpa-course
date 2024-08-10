package com.example.demo.service;

import com.example.demo.entitiy.Book;
import com.example.demo.entitiy.Student;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;

public class FakeStudentService {
    Faker faker;
    public FakeStudentService() {
        faker = new Faker();
    }

    public Student createFakeStudent() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = String.format("%s.%s@gmail.com", firstName, lastName);

        Student student = new Student(firstName, lastName, email, faker.number().numberBetween(18, 55));

        student.assignBook(new Book("Clean Code", LocalDateTime.now()));
        return student;
    }

}
