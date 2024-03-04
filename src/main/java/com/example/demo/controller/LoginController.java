package com.example.demo.controller;

import com.example.demo.Model.*;
import com.example.demo.Service.UserService;
import com.example.demo.config.Common;
import com.example.demo.config.CookieUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/auth")
public class LoginController {

    final UserService userService;

    @PostMapping("/signup")
    @ResponseBody
    public ResultDto signup(UserVO userVO){
        return userService.signup(userVO);
    }



    @PostMapping("/login")
    public ResultDto login(HttpServletRequest request, @RequestBody LoginDTO loginDto , HttpServletResponse response) {
        //user check
           String loginNm = loginDto.getUsername();
           String userCheck  =  userService.selectUser(loginNm);
        System.out.println("userchecck: " + userCheck);

        if(userCheck == null){
            return ResultDto.builder()
                    .result(Common.FAIL)
                    .resultCode(Common.failCode)
                    .data("일치하는 유저가 없습니다")
                    .build();
        }
        TokenDTO tokenDTO = userService.login(loginDto);
        CookieUtils.createCookieForJwt(tokenDTO, response);
        ResultDto resultDto = null;
        /*
         1.로그인을한다
         2.accessToken이 만료되면 db에 잇는 refreshToken을 재발급받아서
         3.accessToken에 넣어준다
         4.리프레시 토큰이 만료되면 다시 로그인하락한다
         5.새로 토큰이 또 발생될때 그 리프레쉬토큰이 기존의 db에 있는 토큰이랑 비교해서
         다르면 업데이트한다 근데 그 리프레시 토큰이 db에 있는 토큰이랑 같으면 잘못발급된 refreshToken이다
         6.refresh마저 만료되면 로그인을 다시 한다
         */
        return ResultDto.builder()
                .data(tokenDTO)
                .build();
    }
}
