package com.example.demo.controller;

import com.example.demo.Model.ResultDto;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/guest")
public class UserController {

    private final UserService userService;

    //유저 체크인 체크아웃
    @GetMapping("/reserveList")
    public ResultDto reserveList(){
        return userService.reserveList();
    }
    //마이페이지
    @GetMapping("/myPage")
    @ResponseBody
    public ResultDto myPage(@RequestParam int id){
        return userService.myPage(id);
    }

    //마이페이지 수정
    @PostMapping("/modify")
    @ResponseBody
    public ResultDto modify(@RequestParam int id){
        return userService.modify(id);
    }

    //유저리스트
    @PostMapping("/user_list")
    @ResponseBody
    public ResultDto userList(){
        return userService.userList();
    }

    //유저리스트 상세
    @PostMapping("/user_detail")
    @ResponseBody
    public ResultDto userDetail(@RequestParam String id){
        return userService.userDetail();
    }

    //file upload


}
