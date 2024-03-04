package com.example.demo.controller;


import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomDetailVO;
import com.example.demo.Model.RoomVO;
import com.example.demo.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/room")
public class RoomApiController {

    private final RoomService roomService;

    //리스트
    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto roomList(){
        return roomService.list();
    }
    //insert
    @PostMapping("/insert")
    @ResponseBody
    public ResultDto roomDetailInsert(RoomVO roomVO){ //@RequestBody 를 빼주니까 됨
   /* public ResultDto roomInsert(
                                 @RequestParam (required = false) String businessNo,
                                 @RequestParam (required = false) String roomType,
                                 @RequestParam (required = false) String roomCode,
                                 @RequestParam  (required = false) int stock
                                 ){*/
        return roomService.insertRoom(roomVO);
    }
    //detail
    @PostMapping("/detail")
    @ResponseBody
    public ResultDto roomDetail(@RequestParam int id){
        return roomService.detail(id);
    }
    //수정
    @PostMapping("/update")
    @ResponseBody
    public ResultDto roomModify(@RequestParam (required = false) String businessNo,
                                 @RequestParam  (required = false) String roomType,
                                 @RequestParam  (required = false) String roomCode,
                                 @RequestParam (required = false) int stock
                                ){
        return roomService.roomModify(businessNo,roomType,roomCode,stock);
    }
    @PostMapping("/delete")
    @ResponseBody
    public ResultDto roomDelete(int id){
        return roomService.delete(id);
    }

}
