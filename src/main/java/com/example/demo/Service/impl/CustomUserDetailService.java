package com.example.demo.Service.impl;

import com.example.demo.Model.UserDto;
import com.example.demo.config.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userMapper.findByUserId(userId)
                .stream().map(user -> addAuthorities(user))
                .findAny().orElseThrow(() -> new UserNotFoundException(userId + "> 찾을 수 없습니다."));
    }
    private UserDto addAuthorities(UserDto userDto) {
        userDto.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDto.getRole())));

        return userDto;
    }
}
