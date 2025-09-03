package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.dto.RegistrationRequest;
import com.example.coursemanagementsystem.entitiy.Registration;

import java.util.List;

public interface RegistrationService {
    List<Registration> getAllRegistrations();
    Registration createRegistration(RegistrationRequest request);
    Registration updateRegistration(Long id, Registration registration);
    void deleteRegistration(Long id);
}
