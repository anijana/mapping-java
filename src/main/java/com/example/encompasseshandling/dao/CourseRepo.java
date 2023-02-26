package com.example.encompasseshandling.dao;

import com.example.encompasseshandling.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,String> {
}
