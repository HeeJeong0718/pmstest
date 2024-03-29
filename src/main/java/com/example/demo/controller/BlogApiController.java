package com.example.demo.controller;

import com.example.demo.Model.BlogResponseDto;
import com.example.demo.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogApiController {

    private final BlogService blogService;

    @GetMapping("/api/v1/blog/{keyword}")
    public BlogResponseDto get(@PathVariable String keyword){
       return blogService.findByKeyword(keyword);
    }

}
