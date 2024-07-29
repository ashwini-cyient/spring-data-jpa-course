package com.example.demo;

import com.example.demo.entitiy.Student;
import com.github.javafaker.Faker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class StudentsService {
    private final StudentRepository _studentRepository;

    public StudentsService(StudentRepository studentRepository) {
        this._studentRepository = studentRepository;

    }

    public void registerStudentsWithFaker() {
        for (int i = 0; i <30 ; i++) {
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@gmail.com", firstName, lastName);

            Student student = new Student(firstName, lastName, email, faker.number().numberBetween(18, 55));
            this._studentRepository.save(student);
        }


    }

    public void findAllStudents(){
        this._studentRepository.findAll().forEach((student)-> System.out.println(student.getFirstName()));
    }

    public void findStudentsOrderByFirstNameAsc() {
        List<Student> students= this._studentRepository.findByOrderByFirstNameAsc();
        students.forEach((student)-> System.out.println(student.getFirstName()));

    }

    public void findStudentsOrderByFirstNameAscJPQL() {
        List<Student> students= this._studentRepository.findByOrderByFirstNameAscJPQL();
        students.forEach((student)-> System.out.println(student.getFirstName()));

    }

    public void findStudentsOrderByFirstNameAscUsingSortObject() {
        List<Student> students= this._studentRepository.findAll(Sort.by("firstName").and(Sort.by("id")));
        students.forEach((student)-> System.out.println(student.getId()+"---"+student.getFirstName()));

    }

    public void findStudentsOrderByFirstNameAscUsingSortObjectAndPagination() {
        Sort sortingLogic = Sort.by("firstName").and(Sort.by("id"));
        PageRequest pageRequest = PageRequest.of(0,5,sortingLogic);
        Page<Student> page = this._studentRepository.findAll(pageRequest);
        System.out.println(page);

    }








}
