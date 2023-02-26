package com.example.encompasseshandling.dao;

import com.example.encompasseshandling.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {
}
