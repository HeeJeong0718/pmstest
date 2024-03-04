package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
    int userId;
    String userName;
    String password;
    String role;
    String accessToken;
    String refreshToken;

}
