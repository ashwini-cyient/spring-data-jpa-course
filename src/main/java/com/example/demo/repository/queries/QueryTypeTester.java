package com.example.demo.repository.queries;

import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

public class QueryTypeTester {
    public void startTesting(StudentRepository studentRepository) {
        Student ashwini = new Student("Ashwini", "Kumar", "ashwini.cyient@gmail.com", 41);

        System.out.println("Add one student");
        studentRepository.save(ashwini); // Saving one student

        Student harshit = new Student("Harshit", "Kumar", "harshit.cyient@gmail.com", 40);
        Student virender = new Student("Virender", "Jain", "virender.cyient@gmail.com", 41);

        List<Student> students =List.of(harshit, virender);

        System.out.println("Add multiple students");
        studentRepository.saveAll(students); // Saving a list of students

        ExistingRepositoryMethods obj1 = new ExistingRepositoryMethods();
        obj1.existingRepositoryMethods(studentRepository);

    }
}
