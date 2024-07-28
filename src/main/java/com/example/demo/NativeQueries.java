package com.example.demo.querytypes;

import com.example.demo.StudentRepository;

public class NativeQueries {
    public void testNativeQueryMethods(StudentRepository studentRepository) {
        //Calling Native Query/Method
        System.out.println("Calling Native Query");
        studentRepository.findStudentWhereFirstNameAndAgeEquals("Virender", 41).ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student with email not found"));
    }
}
