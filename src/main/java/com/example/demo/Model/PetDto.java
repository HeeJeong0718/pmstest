package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetDto {
    int id;
    String pet_name;
    String birthdate;
    String gender;

}
