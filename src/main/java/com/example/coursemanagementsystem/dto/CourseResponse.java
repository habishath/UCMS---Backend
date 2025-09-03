package com.example.coursemanagementsystem.dto;

public class CourseResponse {
    private Long id;
    private String title;
    private String code;
    private int credits;
    private String instructor;

    public CourseResponse(Long id, String title, String code, int credits, String instructor) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.credits = credits;
        this.instructor = instructor;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
