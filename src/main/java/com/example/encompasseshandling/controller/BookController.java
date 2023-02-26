package com.example.encompasseshandling.controller;

import com.example.encompasseshandling.dto.BookDto;
import com.example.encompasseshandling.model.Book;
import com.example.encompasseshandling.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody BookDto book)  {
        Book books =  bookService.addBook(book);
        return books;
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable String bookId) {
        Book books  = bookService.findByBook(bookId);
        return books;
    }


    @GetMapping
    public List<Book> getAllBook(){
        List<Book> allBook = bookService.findAllBook();
        return allBook;
    }

    @GetMapping("/student/{studentID}")
    public List<Book> getAllBook(@PathVariable(value = "studentID") String studentID){
        List<Book> allBook = bookService.findAllBookByStudentId(studentID);
        return allBook;
    }

}

