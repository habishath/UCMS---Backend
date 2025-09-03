package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findByStudentNumber(String studentNumber);
}
