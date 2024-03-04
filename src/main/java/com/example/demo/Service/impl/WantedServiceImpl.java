package com.example.demo.Service.impl;

import com.example.demo.Model.BoardVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Service.BoardService;
import com.example.demo.Service.WantedService;
import com.example.demo.config.Common;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.mapper.WantedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WantedServiceImpl implements WantedService {

    final WantedMapper wantedMapper;


    @Override
    public ResultDto join(String email, String password) {

        //암호화해서 저장

        return null;
    }

}
