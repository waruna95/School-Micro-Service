package com.student.cloud.Controller;

import com.student.cloud.Modal.Student;
import com.student.cloud.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/smscloud")
public class StudentController {

    @Autowired
    StudentService studentService;


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
    public ResponseEntity<Student> fetchStudent(@PathVariable String Id){
        Student student = studentService.fetchStudent(Id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(student);
        }


    }

    }
