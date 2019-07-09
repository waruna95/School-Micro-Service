package com.school.cloud.Repository;

import com.school.cloud.Modal.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Integer> {

    Optional<School> findById(String id);
}
