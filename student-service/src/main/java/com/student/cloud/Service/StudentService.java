package com.student.cloud.Service;


import com.student.cloud.Modal.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> fetchAllStudents();
    Student fetchStudent(String Id);
}
