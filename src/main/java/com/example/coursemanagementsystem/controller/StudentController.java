package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.dto.StudentResponse;
import com.example.coursemanagementsystem.entitiy.Student;
import com.example.coursemanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentResponse> getAll() {
        return service.getAllStudents()
                .stream()
                .map(s -> new StudentResponse(
                        s.getId(),
                        s.getName(),
                        s.getStudentNumber()
                ))
                .toList();
    }


    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

}
