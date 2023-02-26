package com.example.encompasseshandling.service;

import com.example.encompasseshandling.dao.BookRepo;
import com.example.encompasseshandling.dto.BookDto;
import com.example.encompasseshandling.model.Book;
import com.example.encompasseshandling.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private StudentService studentService;

    public Book addBook(BookDto bookDto) {
//        String ID = UUID.randomUUID().toString();

        Student byStudent = studentService.findByStudent(bookDto.getStudentID());
        Book book = new Book();
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setStudent(byStudent);
        book.setDescription(book.getDescription());
        book.setID(ID);
        Book __book = bookRepo.save(book);
        return __book;
    }

    public List<Book> findAllBookByStudentId(String studentID) {
        Student byStudent = studentService.findByStudent(studentID);
        List<Book> allBookByStudent = bookRepo.findAllBookByStudent(byStudent);
        for(Book b:allBookByStudent){
            b.setStudent(null);
        }
        return allBookByStudent;
    }


    public Book findByBook(String bookId){
        Optional<Book> bookOptional = bookRepo.findById(bookId);

        if(bookOptional.isPresent())
            return bookOptional.get();

    }

    public List<Book> findAllBook() {
        List<Book> bookRepoAll = bookRepo.findAll();
        return bookRepoAll;
    }
}
