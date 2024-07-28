package com.example.demo;

import com.example.demo.StudentRepository;

public class JPQLQueries {

    public void jPQLMethods(StudentRepository studentRepository) {
        //Calling JPQL Query/Method
        System.out.println("Calling JPQL Query");
        studentRepository.findStudentWhereEmail("ashwini.cyient@gmail.com").ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student with email not found"));
    }
    public void jPQLQueryMethodsWithNamedParams(StudentRepository studentRepository) {
        //Calling JPQL Query/Method With Named Parameters
        System.out.println("Calling JPQL Query With Named Parameters");
        studentRepository.findStudentWhereEmailWithNamedParams("ashwini.cyient@gmail.com").ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student with email not found"));
    }


}
