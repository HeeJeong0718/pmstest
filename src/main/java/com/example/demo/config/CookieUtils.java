package com.example.demo.config;

import com.example.demo.Model.TokenDTO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static void createCookieForJwt(TokenDTO tokenDTO, HttpServletResponse response) {
        Cookie cookie = new Cookie("token",tokenDTO.getToken());
        Cookie name = new Cookie("name" , tokenDTO.getUsername());
        cookie.setPath("/");
        cookie.setMaxAge( 60 * 1000);
        cookie.setHttpOnly(true);
        name.setPath("/");
        name.setMaxAge(60 * 1000);
        name.setHttpOnly(true);
        response.addCookie(cookie);
        response.addCookie(name);
        //Cookie accessCookie = new Cookie("accessToken", tokenDto.getToken());
        //Cookie accessToken = new Cookie(tokenDto.getToken(), "accessToken");
        // Cookie name = new Cookie("name" , tokenDto.getUsername());

    }
}
