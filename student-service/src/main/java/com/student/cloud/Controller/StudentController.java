package com.student.cloud.Controller;

import com.student.cloud.Modal.School;
import com.student.cloud.Modal.Student;
import com.student.cloud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/smscloud")
public class StudentController {

    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    StudentService studentService;

//    @Bean
//    public RestTemplate getRestTemplate() {
//        return restTemplate;
//    }
@Bean

public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
}

    //save student
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    //get all students
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return ResponseEntity.ok(studentService.fetchAllStudents());
    }

    //get one student
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> fetchStudent(@PathVariable String id){
        System.out.println("ssdfghaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Student student = studentService.fetchStudent(id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(student);
        }


    }

    }
