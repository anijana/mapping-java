package com.example.encompasseshandling.dto;

import com.example.encompasseshandling.model.Address;
import lombok.Data;

@Data

public class StudentDto {

    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;
    private Address address;

}
