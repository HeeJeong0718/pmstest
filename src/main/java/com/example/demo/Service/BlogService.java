package com.example.demo.Service;

import com.example.demo.Model.BlogResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface BlogService {

     BlogResponseDto findByKeyword(String keyword);
}
