package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.dto.ResultDTO;
import com.example.coursemanagementsystem.dto.ResultRequest;
import com.example.coursemanagementsystem.entitiy.Course;
import com.example.coursemanagementsystem.entitiy.Result;
import com.example.coursemanagementsystem.entitiy.Student;
import com.example.coursemanagementsystem.repository.CourseRepository;
import com.example.coursemanagementsystem.repository.ResultRepository;
import com.example.coursemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository repo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<ResultDTO> getAllResults() {
        List<Result> results = repo.findAll();
        return results.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ResultDTO createResult(ResultRequest request) {
        Result result = new Result();
        result.setGrade(request.getGrade());

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        result.setStudent(student);
        result.setCourse(course);

        Result savedResult = repo.save(result);
        return mapToDTO(savedResult);
    }

    @Override
    public ResultDTO updateResult(Long id, ResultRequest request) {
        Result result = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        result.setGrade(request.getGrade());

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        result.setStudent(student);
        result.setCourse(course);

        Result updatedResult = repo.save(result);
        return mapToDTO(updatedResult);
    }


    @Override
    public void deleteResult(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Result not found");
        }
        repo.deleteById(id);
    }

    private ResultDTO mapToDTO(Result result) {
        ResultDTO dto = new ResultDTO();
        dto.setId(result.getId());
        dto.setGrade(result.getGrade());
        if (result.getStudent() != null) {
            dto.setStudentNumber(result.getStudent().getStudentNumber());
        }
        if (result.getCourse() != null) {
            dto.setCourseCode(result.getCourse().getCode());
            dto.setCourseName(result.getCourse().getTitle());
        }
        return dto;
    }
}
