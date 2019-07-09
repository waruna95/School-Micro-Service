package com.student.cloud.Service;

import com.student.cloud.Modal.Student;
import com.student.cloud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudent(String Id) {
        Optional<Student> optional = studentRepository.findById(Id);
        Student student1 = optional.get();
        return student1;
    }
}
