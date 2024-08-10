package com.example.demo;

import com.example.demo.entitiy.Student;
import com.example.demo.repository.LibraryCardRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.FakeStudentService;
import com.example.demo.service.LibraryCardService;
import com.example.demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, LibraryCardRepository libraryCardRepository) {
        return args -> {

            FakeStudentService fakeStudentService = new FakeStudentService();
            Student fakeStudent = fakeStudentService.createFakeStudent();

            System.out.println("------------------Add Student-------------------------------");
            StudentService studentService = new StudentService(studentRepository);
            studentService.addStudent(fakeStudent);

            System.out.println("------------------Find Student-------------------------------");
            Student student = studentService.getStudentById(1L);

            System.out.println("------------------Issue ID Card-------------------------------");
            LibraryCardService idCardService = new LibraryCardService(libraryCardRepository);
            idCardService.issueLibraryCard(student);

        };
    }

    /*@Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, LibraryCardRepository libraryCardRepository) {
        return args -> {
           *//* QueryTypeTester tester = new QueryTypeTester();
            tester.startTesting(studentRepository);*//*

            FakeStudentService fakeStudentService = new FakeStudentService();
            *//*
            StudentService ft = new StudentService(studentRepository,fakerUtil);
            System.out.println("------------------Register Students-------------------------------");
            ft.registerStudentsWithFaker();
            System.out.println("------------------findStudentsOrderByFirstNameAsc-------------------------------");
            ft.findStudentsOrderByFirstNameAsc();
            System.out.println("------------------findStudentsOrderByFirstNameAscJPQL-------------------------------");
            ft.findStudentsOrderByFirstNameAscJPQL();
            System.out.println("------------------findStudentsOrderByFirstNameAscUsingSortObject-------------------------------");
            ft.findStudentsOrderByFirstNameAscUsingSortObject();
            System.out.println("------------------findStudentsOrderByFirstNameAscUsingSortObjectAndPagination-------------------------------");
            ft.findStudentsOrderByFirstNameAscUsingSortObjectAndPagination();*//*

            Student fakeStudent = fakeStudentService.createFakeStudent();

            System.out.println("------------------Register Student-------------------------------");
            StudentService studentService = new StudentService(studentRepository);
            studentService.addStudent(fakeStudent);

            System.out.println("------------------Find Student-------------------------------");
            Student student = studentService.getStudentById(1L);

            System.out.println("------------------Make Id Card for Student-------------------------------");
            LibraryCardService idCardService = new LibraryCardService(libraryCardRepository, studentService);
            idCardService.issueLibraryCard(1L);

            *//*System.out.println("------------------Find StudentIdCardById-------------------------------");
            idCardService.findStudentIdCardById(1L);*//*
            *//*idCardService.findStudentIdCards();*//*


        };
    }*/


}
