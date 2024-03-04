package com.example.demo.Service;

import com.example.demo.Model.BlogResponseDto;
import com.example.demo.Model.ResultDto;

public interface WantedService {

     ResultDto join(String email, String password);
}
