package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberDTO {
     private String member_id;   //아이디
     private String member_password;     //비밀번호
     private String member_name;     //이름

}
