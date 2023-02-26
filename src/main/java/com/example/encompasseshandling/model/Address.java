package com.example.encompasseshandling.model;

import jakarta.persistence.*;
import lombok.Data;

package com.example.mapping.model;

import lombok.Data;

@Data
public class Address {
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;

}