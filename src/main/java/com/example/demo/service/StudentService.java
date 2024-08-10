package com.example.demo.service;

import com.example.demo.entitiy.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentRepository _studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this._studentRepository = studentRepository;

    }

    public Long addStudent(Student student){
        Long id = -1l;
        try {
            Student stud = this._studentRepository.save(student);
            id = stud.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public Student getStudentById(Long id){
        Optional<Student> student = this._studentRepository.findById(id);
        return student.orElse(null);
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



    /*addStudent(Student student)
    updateStudent(Student student)
    removeStudent(Long studentId)
    getStudentById(Long studentId)
    getAllStudents()
    assignBookToStudent(Student student, Book book)
    unassignBookFromStudent(Student student, Book book)
*/


}
