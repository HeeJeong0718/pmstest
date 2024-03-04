package com.example.demo.mapper;

import com.example.demo.Model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Mapper
@Repository
public interface UserMapper {


    ArrayList<UserVO> list();

    int createUser(UserVO userVO);
    int myPage(int id);

    int  modify(int id);

    UserDto findByUsername(@RequestParam("username") String username);

    String selectUser(String username);

    ArrayList<UserDto> findByUserId(@RequestParam("userId")String userId);

    UserDto findByUserId2(@RequestParam("userId")String userId);

    MemberDTO findByUsername2(@RequestParam("member_id") String username);


}
