package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.dto.RegistrationRequest;
import com.example.coursemanagementsystem.entitiy.Course;
import com.example.coursemanagementsystem.entitiy.Registration;
import com.example.coursemanagementsystem.entitiy.Student;
import com.example.coursemanagementsystem.repository.CourseRepository;
import com.example.coursemanagementsystem.repository.RegistrationRepository;
import com.example.coursemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationRepository repo;

    @Override
    public List<Registration> getAllRegistrations() {
        return repo.findAll();
    }

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Registration createRegistration(RegistrationRequest request) {
        Student student = studentRepo.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepo.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Registration reg = new Registration();
        reg.setStudent(student);
        reg.setCourse(course);
        reg.setRegistrationDate(request.getRegistrationDate());

        return repo.save(reg);
    }

    @Override
    public Registration updateRegistration(Long id, Registration registration) {
        Optional<Registration> existing = repo.findById(id);
        if (existing.isPresent()) {
            registration.setId(id);
            return repo.save(registration);
        }
        throw new RuntimeException("Registration not found");
    }

    @Override
    public void deleteRegistration(Long id) {
        repo.deleteById(id);
    }
}
