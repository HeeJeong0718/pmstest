package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberVO {

     int id;
     String pwd;
     String user_nm;
     String email;

}
