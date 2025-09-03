package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
