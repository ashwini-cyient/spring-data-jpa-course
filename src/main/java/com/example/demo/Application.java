package com.example.demo;

import com.example.demo.faker.FakerTester;
import com.example.demo.querytypes.QueryTypeTester;
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
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
           /* QueryTypeTester tester = new QueryTypeTester();
            tester.startTesting(studentRepository);*/

            FakerTester ft = new FakerTester();
            ft.registerStudentsWithFaker(studentRepository);



        };
    }









}
