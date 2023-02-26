package com.example.encompasseshandling.service;

import com.example.encompasseshandling.dao.CourseRepo;
import com.example.encompasseshandling.dao.StudentRepo;
import com.example.encompasseshandling.dto.CourseDto;
import com.example.encompasseshandling.dto.CourseStudentDto;
import com.example.encompasseshandling.model.Course;
import com.example.encompasseshandling.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    public Course addCourse(CourseDto courseDto) {

        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDuration(courseDto.getDuration());
        course.setDescription(courseDto.getDescription());
        Course courses = courseRepo.save(course);
        return courses;
    }

    public Course findByCourse(String courseId) {
        Optional<Course> courseOptional = courseRepo.findById(courseId);

        if (courseOptional.isPresent())
            return courseOptional.get();

    }



    public List<Course> findAllCourse() {
        List<Course> courseRepoAll = courseRepo.findAll();
        return courseRepoAll;
    }

    public Course addCourseToStudent(CourseStudentDto course) {
        Student byStudent = studentService.findByStudent(course.getStudentId());

        Optional<Course> optionalCourse = courseRepo.findById(course.getCourseId());
        if(optionalCourse.isPresent()){

            Course course1 = optionalCourse.get();
            List<Student> studentList = new ArrayList<>();

            studentList.add(byStudent);
            course1.setStudentList(studentList);
            Course save = courseRepo.save(course1);
            return save;
        }
        return null;
    }

    public void addStudentToCourse(String studentId, String courseId){
        Optional<Course> optionalCourse = this.courseRepo.findById(courseId);


        if(optionalCourse.isPresent()){
            Student student = this.studentService.findByStudent(studentId);

            Course course = optionalCourse.get();
            List<Student> studentList = course.getStudentList();
            studentList.add(student);
            courseRepo.save(course);

        }

    }
}
