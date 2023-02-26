package com.example.encompasseshandling.controller;

import com.example.encompasseshandling.dto.CourseDto;
import com.example.encompasseshandling.dto.CourseStudentDto;
import com.example.encompasseshandling.model.Course;
import com.example.encompasseshandling.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody CourseDto course){
        Course courses =  courseService.addCourse(course);
        return courses;
    }

    @PostMapping("/student")
    public Course addCourseToStudent(@RequestBody CourseStudentDto course) {
        Course courses =  courseService.addCourseToStudent(course);
        return courses;
    }


    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable String courseId)  {
        Course courses  = courseService.findByCourse(courseId);
        return courses;
    }


    @GetMapping
    public List<Course> getAllCourse(){
        List<Course> allCourse = courseService.findAllCourse();
        return allCourse;
    }

    @PostMapping("course/student/add")
    public String addStudentToCourse(@RequestParam(value = "studentId",required = true)String studentId,
                                     @RequestParam(value="courseId",required = true)String courseId) {
        this.courseService.addStudentToCourse(studentId,courseId);
        return "student added to course";
    }


}
