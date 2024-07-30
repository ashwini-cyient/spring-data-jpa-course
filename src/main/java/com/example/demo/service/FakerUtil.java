package com.example.demo.service;

import com.example.demo.entitiy.Student;
import com.github.javafaker.Faker;

public class FakerUtil {
    Faker faker;
    public FakerUtil() {
        faker = new Faker();
    }

    public Student createFakeStudent() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = String.format("%s.%s@gmail.com", firstName, lastName);

        Student student = new Student(firstName, lastName, email, faker.number().numberBetween(18, 55));
        return student;
    }

}
