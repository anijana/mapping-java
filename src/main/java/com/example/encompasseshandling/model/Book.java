package com.example.encompasseshandling.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Book {

    @Id

    private String ID;

    private String title;
    private String author;
    private String description;
    private String price;


    @ManyToOne
    private Student student;

}