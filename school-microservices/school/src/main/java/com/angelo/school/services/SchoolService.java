package com.angelo.school.services;

import com.angelo.school.entities.FullSchoolResponse;
import com.angelo.school.entities.School;
import com.angelo.school.feign.StudentClient;
import com.angelo.school.repositories.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> listAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = repository.findById(schoolId)
                .orElse(School.builder()
                        .email("NULL")
                        .name("NULL")
                        .build());
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
