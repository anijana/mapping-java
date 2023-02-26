package com.example.encompasseshandling.dao;

import com.example.encompasseshandling.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop, String> {
}
