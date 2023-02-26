package com.example.encompasseshandling.service;

import com.example.encompasseshandling.dao.LaptopRepo;
import com.example.encompasseshandling.dao.StudentRepo;
import com.example.encompasseshandling.dto.LaptopDto;
import com.example.encompasseshandling.model.Laptop;
import com.example.encompasseshandling.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    public Laptop addLaptop(LaptopDto laptopDto){
        Student byStudent = studentService.findByStudent(laptopDto.getStudentID());
        Laptop laptop = new Laptop();

        laptop.setName(laptopDto.getName());
        laptop.setBrand(laptopDto.getBrand());

        laptop.setPrice(laptopDto.getPrice());
        laptop.setStudent(byStudent);


        Laptop Laptops = laptopRepo.save(laptop);

        return Laptops;
    }

    public Laptop findByLaptop(String laptopId){
        Optional<Laptop> LaptopOptional = laptopRepo.findById(laptopId);

        if(LaptopOptional.isPresent())
            return LaptopOptional.get();

    }

    public List<Laptop> findAllLaptop() {
            List<Laptop> LaptopRepoAll = laptopRepo.findAll();
            return LaptopRepoAll;
        }
}
