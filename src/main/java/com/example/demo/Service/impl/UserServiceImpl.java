package com.example.demo.Service.impl;

import com.example.demo.Model.*;
import com.example.demo.Service.HotelService;
import com.example.demo.Service.UserService;
import com.example.demo.config.Common;
import com.example.demo.config.JwtUtils;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService  {

    final UserMapper userMapper;
    final JwtUtils jwtUtils;


    @Override
    public ResultDto signup(UserVO userVO) {
        //PostMapping으로 데이터를 Insert 할때 리턴 타입은 int가 되어야 한다.
        //form으로 보내줄때 파라미터 타입으로는 userVO를 통으로 보내지만
        //mybatis insert시에는 리턴타입을 int로 지정한다 insert시에는 return 타입이없음
        int result = userMapper.createUser(userVO);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();

    }
    @Override
    public String selectUser(String loginNm) {
        String result = userMapper.selectUser(loginNm);
        return result;

    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        UserDto userDto = userMapper.findByUsername(loginDTO.getUsername());
       // UserDto userDto = userMapper.findByUserId(loginDTO.getUserId());
        return jwtUtils.createToken(userDto.getUserId(), Collections.singletonList(userDto.getRole()));
    }


    @Override
    public ResultDto reserveList() {
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(userMapper.list())
                .build();

    }

    @Override
    //마이페이지
    public ResultDto myPage(int id) {

         int result = userMapper.myPage(id);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(1 == result ? Common.successCode : Common.failCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto modify(int id) {

        int reuslt = userMapper.modify(id);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(reuslt)
                .build();
    }

    @Override
    public ResultDto userList() {

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                //.data()
                .build();
    }
    @Override
    public ResultDto userDetail() {
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                //.data()
                .build();
    }

}
