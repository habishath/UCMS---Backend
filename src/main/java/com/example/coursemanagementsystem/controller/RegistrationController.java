package com.example.coursemanagementsystem.controller;


import com.example.coursemanagementsystem.dto.CourseResponse;
import com.example.coursemanagementsystem.dto.RegistrationRequest;
import com.example.coursemanagementsystem.dto.RegistrationResponse;
import com.example.coursemanagementsystem.dto.StudentResponse;
import com.example.coursemanagementsystem.entitiy.Registration;
import com.example.coursemanagementsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "*")
public class RegistrationController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<RegistrationResponse> getAllRegistrations() {
        List<Registration> registrations = service.getAllRegistrations();

        return registrations.stream()
                .map(registration -> new RegistrationResponse(
                        registration.getId(),
                        new StudentResponse(
                                registration.getStudent().getId(),
                                registration.getStudent().getName(),
                                registration.getStudent().getStudentNumber()
                        ),
                        new CourseResponse(
                                registration.getCourse().getId(),
                                registration.getCourse().getTitle(),
                                registration.getCourse().getCode(),
                                registration.getCourse().getCredits(),
                                registration.getCourse().getInstructor()
                        ),
                        registration.getRegistrationDate()
                ))
                .toList();
    }


    @PostMapping
    public RegistrationResponse create(@RequestBody RegistrationRequest request) {
        Registration registration = service.createRegistration(request);

        return new RegistrationResponse(
                registration.getId(),
                new StudentResponse(
                        registration.getStudent().getId(),
                        registration.getStudent().getName(),
                        registration.getStudent().getStudentNumber()
                ),
                new CourseResponse(
                        registration.getCourse().getId(),
                        registration.getCourse().getTitle(),
                        registration.getCourse().getCode(),
                        registration.getCourse().getCredits(),
                        registration.getCourse().getInstructor()
                ),
                registration.getRegistrationDate()
        );
    }


    @PutMapping("/{id}")
    public Registration update(@PathVariable Long id, @RequestBody Registration registration) {
        return service.updateRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRegistration(id);
    }

}
