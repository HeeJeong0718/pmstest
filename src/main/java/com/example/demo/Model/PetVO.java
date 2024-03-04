package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class PetVO {
    int id;
    String pet_name;
    String birthdate;
    String gender;

}
