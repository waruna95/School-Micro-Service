package com.student.cloud.Repository;

import com.student.cloud.Modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findById(String id);
}
