package com.example.demo.controller;

import com.example.demo.Model.ResultDto;
import com.example.demo.Service.WantedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/v1")
public class WantedApiController {

    private final WantedService wantedService;

    //회원가입
    @PostMapping("/join")
    @ResponseBody
    public ResultDto join(@RequestParam String email, @RequestParam String password){
        return wantedService.join(email, password);
    }
}
