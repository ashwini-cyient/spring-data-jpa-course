package com.example.demo.faker;

import com.example.demo.Student;
import com.example.demo.StudentRepository;
import com.github.javafaker.Faker;

public class FakerTester {

    public void registerStudentsWithFaker(StudentRepository studentRepository) {
        for (int i = 0; i <30 ; i++) {
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);

            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(18, 55));
            studentRepository.save(student);
        }

        studentRepository.findAll().forEach(System.out::println);
    }
}
