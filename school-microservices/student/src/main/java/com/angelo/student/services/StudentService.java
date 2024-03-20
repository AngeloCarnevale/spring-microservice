package com.angelo.student.services;

import com.angelo.student.domain.entities.Student;
import com.angelo.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> listAllStudents() {
        return repository.findAll();
    }
    public List<Student> findAllStudentsBySchool(Long schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
