package com.example.demo.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TokenDTO {

    int userId;
    String username;
    String token;
    String role;
    String refreshToken;
}
