package com.example.demo.controller;


import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomDetailVO;
import com.example.demo.Service.RoomDetailService;
import com.example.demo.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/roomDetail")
public class RoomDetailApiController {

    private final RoomDetailService roomDetailService;

    //리스트
    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto roomList(){
        return roomDetailService.list();
    }
    //insert
    @PostMapping("/insert")
    @ResponseBody
    public ResultDto roomDetailInsert(RoomDetailVO roomDetailVO){ //@RequestBody 를 빼주니까 됨
        return roomDetailService.roomDetailInsert(roomDetailVO);
    }
   /* public ResultDto roomDetailInsert(
                                 @RequestParam (required = false) String roomNo,
                                 @RequestParam (required = false) String roomCode,
                                 @RequestParam (required = false) String roomStatus
                                 ){
        return roomDetailService.roomDetailInsert(roomNo,roomCode,roomStatus);
    }*/
    //detail
    @PostMapping("/detail")
    @ResponseBody
    public ResultDto  roomStatusDetail(@RequestParam String roomCode){
        return roomDetailService.roomStatusDetail(roomCode);
    }
    //수정
    @PostMapping("/update")
    @ResponseBody
    public ResultDto detailModify(
                                 @RequestParam  (required = false) String roomStatus
                                ){
        return roomDetailService.detailModify(roomStatus);
    }
    @PostMapping("/delete")
    @ResponseBody
    public ResultDto roomDelete(int id){
        return roomDetailService.delete(id);
    }

}
