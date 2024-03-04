package com.example.demo.controller;


import com.example.demo.Model.ResultDto;
import com.example.demo.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/hotel")
public class HotelApiController {

    private final HotelService hotelService;

    //리스트
    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto hotelList(){
        return hotelService.list();
    }
    //insert
    @CrossOrigin(origins="*")
    @PostMapping("/insert")
    @ResponseBody
    public ResultDto hotelInsert(
                                 @RequestParam (required = false) String hotelName,
                                 @RequestParam (required = false) String businessNo,
                                 @RequestParam (required = false) String address,
                                 @RequestParam  (required = false) Integer numRooms
                                 ){
        return hotelService.insertHotel(hotelName,businessNo,address,numRooms);
    }

    /*public ResultDto hotelInsert(
            @RequestParam (required = false) String hotel_name
    ){
        return hotelService.insertHotel(hotel_name);
    }*/

    //detail
    @PostMapping("/detail")
    @ResponseBody
    public ResultDto hotelDetail(@RequestParam int id){
        return hotelService.detail(id);
    }
    //수정
    @PostMapping("/update")
    @ResponseBody
    public ResultDto hotelModify(@RequestParam (required = false) String hotelName,
                                 @RequestParam  (required = false) String address,
                                 @RequestParam  (required = false) String businessNo,
                                 @RequestParam (required = false) int numRooms){
        return hotelService.updateHotel(hotelName,address,businessNo,numRooms);
    }
    @PostMapping("/delete")
    @ResponseBody
    public ResultDto hotelDelete(int id){
        return hotelService.delete(id);
    }

    //포인트차감 증가
    @PostMapping("/point")
    @ResponseBody
    public ResultDto adjustPoint(@RequestParam String guest_id){
        return hotelService.adjustPoint(guest_id);
    }


}
