package com.example.demo;

import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentIdCardRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.FakerUtil;
import com.example.demo.service.StudentIdCardService;
import com.example.demo.service.StudentService;
import com.github.javafaker.Faker;
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
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdCardRepository studentIdCardRepository){
        return args -> {
           /* QueryTypeTester tester = new QueryTypeTester();
            tester.startTesting(studentRepository);*/

            FakerUtil fakerUtil = new FakerUtil();
            /*
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
            ft.findStudentsOrderByFirstNameAscUsingSortObjectAndPagination();*/

            StudentIdCardService idCardService = new StudentIdCardService(studentIdCardRepository,fakerUtil);
            System.out.println("------------------Register Students with Id Cards-------------------------------");
            idCardService.createStudentCard();
            System.out.println("------------------Find StudentIdCardById-------------------------------");
            idCardService.findStudentIdCardById(1L);
            /*idCardService.findStudentIdCards();*/

            StudentService studentService = new StudentService(studentRepository, fakerUtil);

            System.out.println("------------------Find Student-------------------------------");
            studentService.findStudentById(1L);





        };
    }









}
