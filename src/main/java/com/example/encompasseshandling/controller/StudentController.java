package com.example.encompasseshandling.controller;

import com.example.encompasseshandling.model.Student;
import com.example.encompasseshandling.service.StudentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody StudentDto student){
        Student students =  studentService.addStudent(student);
        return students;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId){
        Student students  = studentService.findByStudent(studentId);
        return students;
    }


    @GetMapping
    public List<Student> getAllStudent(){
        List<Student> allStudent = studentService.findAllStudent();
        return allStudent;
    }
}