package com.example.demo.controller;

import com.example.demo.Model.ResultDto;
import com.example.demo.Model.TestVO;
import com.example.demo.Service.ReservationService;
import com.example.demo.config.Common;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
    final ReservationService reservationService;


    @GetMapping("/users")
    @PreAuthorize("hasRole('USER')")
    public String userAccess(){
        return "Login Success";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess(){
        return "admin Success";
    }

    //보냇다->html호출 ->
    /*@PostMapping("/test")
    @ResponseBody
    public ResultDto test(@RequestBody TestVO testVO){
        String test = testVO.getPoint();

        return ResultDto.builder()
                .data(testVO)
                .build();
    }*/
    //클라에서 버튼을 누르고 /api/test/test를 호출을 하면
    //해당 api가 실행이되면서 내가 결과로 return 하는
    //result, data를 쿨라에서 받는다
    @PostMapping("/test")
    @ResponseBody
    public ResultDto test(@RequestParam (required = false )String name){
        System.out.println("name:" + name);
        return ResultDto.builder()
                .data(name)
                .build();
    }
    //연습2 화면이 로드된 후 데이터를 받을때
    @PostMapping("/select_test")
    @CrossOrigin(origins = "http://localhost:18001")
    public ResultDto select_test(){
        return reservationService.reserveList();
    }


    //응답
    /*@PostMapping("/test2")
    @ResponseBody
    public ResultDto test2(@RequestParam String code){
        if(code.equals("1234")){
            System.out.println("Test성공");
        }
        return ResultDto.builder()
                .build();
    }*/


}
