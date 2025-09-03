package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.dto.ResultDTO;
import com.example.coursemanagementsystem.dto.ResultRequest;

import java.util.List;

public interface ResultService {
    List<ResultDTO> getAllResults();
    ResultDTO createResult(ResultRequest request);
    ResultDTO updateResult(Long id, ResultRequest request);
    void deleteResult(Long id);
}
