package com.example.encompasseshandling.controller;

import com.example.encompasseshandling.dto.LaptopDto;
import com.example.encompasseshandling.model.Laptop;
import com.example.encompasseshandling.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laptop")

public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public Laptop addLaptop(@RequestBody LaptopDto laptop) {
        Laptop laptops =  laptopService.addLaptop(laptop);
        return laptops;
    }

    @GetMapping("/{laptopId}")
    public Laptop getLaptop(@PathVariable String laptopId) {
        Laptop laptops  = laptopService.findByLaptop(laptopId);
        return laptops;
    }


    @GetMapping
    public List<Laptop> getAllLaptop(){
        List<Laptop> allLaptop = laptopService.findAllLaptop();
        return allLaptop;
    }
}
