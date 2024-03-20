package com.angelo.school.controllers;

import com.angelo.school.entities.FullSchoolResponse;
import com.angelo.school.entities.School;
import com.angelo.school.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools () {
        return ResponseEntity.ok(service.listAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAll(@PathVariable("school-id") Long schoolId) {
        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
    }
}
