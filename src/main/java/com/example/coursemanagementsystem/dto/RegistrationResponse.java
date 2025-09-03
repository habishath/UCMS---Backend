package com.example.coursemanagementsystem.dto;

import java.time.LocalDate;

public class RegistrationResponse {
    private Long id;
    private StudentResponse student;
    private CourseResponse course;
    private LocalDate registrationDate;

    public RegistrationResponse(Long id, StudentResponse student, CourseResponse course, LocalDate registrationDate) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.registrationDate = registrationDate;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public StudentResponse getStudent() { return student; }
    public void setStudent(StudentResponse student) { this.student = student; }

    public CourseResponse getCourse() { return course; }
    public void setCourse(CourseResponse course) { this.course = course; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
}