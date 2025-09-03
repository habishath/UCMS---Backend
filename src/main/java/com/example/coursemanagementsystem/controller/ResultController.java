package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.dto.ResultDTO;
import com.example.coursemanagementsystem.dto.ResultRequest;
import com.example.coursemanagementsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "*")
public class ResultController {
    @Autowired
    private ResultService service;

    @GetMapping
    public List<ResultDTO> getAllResults() {
        return service.getAllResults();
    }

    @PostMapping
    public ResultDTO createResult(@RequestBody ResultRequest request) {
        return service.createResult(request);
    }

    @PutMapping("/{id}")
    public ResultDTO updateResult(@PathVariable Long id, @RequestBody ResultRequest request) {
        return service.updateResult(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        service.deleteResult(id);
    }

}
