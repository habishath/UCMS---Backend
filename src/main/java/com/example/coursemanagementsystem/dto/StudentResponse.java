package com.example.coursemanagementsystem.dto;

public class StudentResponse {
    private Long id;
    private String name;
    private String studentNumber;

    public StudentResponse(Long id, String name, String studentNumber) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
