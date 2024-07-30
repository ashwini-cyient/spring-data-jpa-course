package com.example.demo.repository.queries;

import com.example.demo.repository.StudentRepository;

public class CustomQueries {
    public void customQueries(StudentRepository studentRepository) {
        //Calling Custom Query/Method
        System.out.println("Calling Custom Query");
        studentRepository.findStudentByEmail("ashwini.cyient@gmail.com").ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student with email not found"));
    }
}
