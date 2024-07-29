package com.example.demo;

import com.example.demo.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    /*Custom Query/Method*/
    Optional<Student> findStudentByEmail(String email);

    /*JPQL Query/Method*/
    @Query("SELECT s FROM Student s WHERE s.email = ?1")/*JPQL*/
    Optional<Student> findStudentWhereEmail(String email);


    @Query("SELECT s FROM Student s WHERE s.email = :email")/*JPQL*/
    Optional<Student> findStudentWhereEmailWithNamedParams(@Param("email") String email);

    /*Native Query/Method*/
    @Query(value = "SELECT * FROM student s where s.first_name = ?1 AND s.age = ?2", nativeQuery = true)/*SQL*/
    Optional<Student> findStudentWhereFirstNameAndAgeEquals(String firstName, Integer age);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    int deleteStudentById(@Param("id")Long id);
    List<Student> findByOrderByFirstNameAsc();

    @Query("SELECT s FROM Student s ORDER BY s.firstName ASC")
    List<Student> findByOrderByFirstNameAscJPQL();






}
