package com.example.demo.Service;

import com.example.demo.Model.MemberDTO;
import com.example.demo.Model.ResultDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {

     //리스트
     ResultDto reserveList();

     ResultDto myPage(int id);

     ResultDto modify(int id);
     ResultDto userList();

     ResultDto userDetail();

     MemberDTO checkLogin(String username, String password);

     UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
