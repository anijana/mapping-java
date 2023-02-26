package com.example.encompasseshandling.dao;

import com.example.encompasseshandling.model.Book;
import com.example.encompasseshandling.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,String> {

}
