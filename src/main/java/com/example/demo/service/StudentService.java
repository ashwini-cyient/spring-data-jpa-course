package com.example.demo.service;

import com.example.demo.entitiy.Student;
import com.example.demo.entitiy.StudentIdCard;
import com.example.demo.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentRepository _studentRepository;
    private FakerUtil _fakerUtil;

    public StudentService(StudentRepository studentRepository, FakerUtil fakerUtil) {
        this._studentRepository = studentRepository;
        this._fakerUtil = fakerUtil;

    }

    public void registerStudentsWithFaker() {
        for (int i = 0; i < 30; i++) {
            this._studentRepository.save(_fakerUtil.createFakeStudent());
        }


    }

    public void findAllStudents() {
        this._studentRepository.findAll().forEach((student) -> System.out.println(student.getFirstName()));
    }

    public void findStudentsOrderByFirstNameAsc() {
        List<Student> students = this._studentRepository.findByOrderByFirstNameAsc();
        students.forEach((student) -> System.out.println(student.getFirstName()));

    }

    public void findStudentsOrderByFirstNameAscJPQL() {
        List<Student> students = this._studentRepository.findByOrderByFirstNameAscJPQL();
        students.forEach((student) -> System.out.println(student.getFirstName()));

    }

    public void findStudentsOrderByFirstNameAscUsingSortObject() {
        List<Student> students = this._studentRepository.findAll(Sort.by("firstName").and(Sort.by("id")));
        students.forEach((student) -> System.out.println(student.getId() + "---" + student.getFirstName()));

    }

    public void findStudentsOrderByFirstNameAscUsingSortObjectAndPagination() {
        Sort sortingLogic = Sort.by("firstName").and(Sort.by("id"));
        PageRequest pageRequest = PageRequest.of(0, 5, sortingLogic);
        Page<Student> page = this._studentRepository.findAll(pageRequest);
        System.out.println(page);

    }

    public void findStudentById(Long id){
        this._studentRepository.findById(id).ifPresent(System.out::println);


    }


}
