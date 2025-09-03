package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
