package com.example.demo;

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
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           /* QueryTypeTester tester = new QueryTypeTester();
            tester.startTesting(studentRepository);*/

            StudentsService ft = new StudentsService(studentRepository);
            System.out.println("------------------Register Students-------------------------------");
            ft.registerStudentsWithFaker();
            System.out.println("------------------findStudentsOrderByFirstNameAsc-------------------------------");
            ft.findStudentsOrderByFirstNameAsc();
            System.out.println("------------------findStudentsOrderByFirstNameAscJPQL-------------------------------");
            ft.findStudentsOrderByFirstNameAscJPQL();
            System.out.println("------------------findStudentsOrderByFirstNameAscUsingSortObject-------------------------------");
            ft.findStudentsOrderByFirstNameAscUsingSortObject();
            System.out.println("------------------findStudentsOrderByFirstNameAscUsingSortObjectAndPagination-------------------------------");
            ft.findStudentsOrderByFirstNameAscUsingSortObjectAndPagination();




        };
    }









}
