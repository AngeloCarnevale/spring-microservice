package com.angelo.school.repositories;

import com.angelo.school.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
