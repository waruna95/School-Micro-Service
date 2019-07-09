package com.student.cloud.Service;

import com.student.cloud.Modal.School;
import com.student.cloud.Modal.Student;
import com.student.cloud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

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
        System.out.println("sdohdfsoghsdohoahsohfdi");
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<School[]> responseEntity;
        HttpEntity< String> entity = new HttpEntity<>("",httpHeaders);
        responseEntity = restTemplate.exchange("http://localhost:8080/smscloud/school"
                , HttpMethod.GET,entity, School[].class);
        System.out.println("succes got details");

        Optional<Student> optional = studentRepository.findById(Id);
        Student student1 = optional.get();
        student1.setSchools(responseEntity.getBody());
        School school = (School) Arrays.stream(responseEntity.getBody()).filter(school1 -> school1.getName().equalsIgnoreCase(student1.getSchoolname()));

        student1.setSchoolCity(school.getCity());
        return student1;
    }
}
