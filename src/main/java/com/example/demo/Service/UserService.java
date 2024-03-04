package com.example.demo.Service;

import com.example.demo.Model.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.security.auth.login.LoginException;

public interface UserService {

     //리스트
     ResultDto reserveList();

     ResultDto signup(UserVO userVO);

     ResultDto myPage(int id);

     ResultDto modify(int id);
     ResultDto userList();

     ResultDto userDetail();

     String selectUser(String loginNm);

     TokenDTO login(LoginDTO loginDTO);

     //  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    // MemberDTO checkLogin(String username, String password) throws LoginException;
}
