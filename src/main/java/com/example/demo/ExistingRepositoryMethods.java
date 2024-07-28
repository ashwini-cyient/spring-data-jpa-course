package com.example.demo.querytypes;

import com.example.demo.Student;
import com.example.demo.StudentRepository;

import java.util.List;

public class ExistingRepositoryMethods {

    public void existingRepositoryMethods(StudentRepository studentRepository) {
        System.out.println("Print count of Students");
        System.out.println("No of students :"+ studentRepository.count());

        System.out.println("Find one student");
        studentRepository.findById(1L).ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student 1L not found"));
        studentRepository.findById(2L).ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student 2L not found"));
        studentRepository.findById(3L).ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student 3L not found"));
        studentRepository.findById(4L).ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student 4L not found"));

        System.out.println("Find all students");
        List<Student> allStudents = studentRepository.findAll();
        allStudents.forEach(System.out::println);

        System.out.println("Delete one student");
        studentRepository.deleteById(2L);

        System.out.println("Print count of Students");
        System.out.println("No of students :"+ studentRepository.count());

        System.out.println("Find all students");
        allStudents = studentRepository.findAll();

        System.out.println("Print remaining Students");
        allStudents.forEach(System.out::println);

        System.out.println("Find student by Email");
        studentRepository.findStudentByEmail("ashwini.cyient@gmail.com").ifPresentOrElse(student->System.out.println(student), () -> System.out.println("Student with email not found"));

    }

    public void testDeleteMethods(StudentRepository studentRepository) {
        //Calling Delete Query
        System.out.println("Calling Delete Query");
        studentRepository.deleteStudentById(3L);
    }
}
