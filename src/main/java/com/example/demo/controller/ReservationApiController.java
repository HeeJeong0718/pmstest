package com.example.demo.controller;

import com.example.demo.Model.*;
import com.example.demo.Service.ReservationService;
import com.example.demo.Service.UserService;
import com.example.demo.config.JwtUtils;
import com.example.demo.config.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/reserve")
public class ReservationApiController {

    private final ReservationService reservationService;
    private final UserService userService;

    //사용가능한 방 list api
    @PostMapping("/show_avaliable_room")
    public ResultDto show_avaliable_room(){
        return reservationService.showRoom();
    }

    //id 값 받아서 해당 룸 보여주기
    @PostMapping("/showRoom")
    @ResponseBody
    public ResultDto showRoom(@RequestParam (required = false) Integer id){
        return reservationService.showSelectedRoom(id);
    }



    @PostMapping("/reserve_list")
    public ResultDto reserve_list(){
        return reservationService.reserveList();
    }


    //호텔예약하기
    @PostMapping("/reserve")
    public ResultDto reserve(@RequestParam (required = false)  String guestId,
                             @RequestParam (required = false)String guestName,
                             @RequestParam (required = false) String bookingDate,
                             @RequestParam (required = false) String checkIn,
                             @RequestParam (required = false) String checkOut,
                             @RequestParam (required = false) String phone,
                             @RequestParam (required = false) String roomType
                             ){
        return reservationService.reserve(guestId,guestName,bookingDate,checkIn,checkOut,phone, roomType);
    }
    //호텔예약하기
    @PostMapping("/reserve2")
    public ResultDto reserve2(@RequestBody ReservationVO reservationVO){
        return reservationService.reserve2(reservationVO);
    }

    //예약상세
    @PostMapping("/reserve_detail")
    public ResultDto reserve_detail(
                             @RequestParam (required = false)String guestName){
        return reservationService.reserveDetail(guestName);
    }
    //예약확정
    @PostMapping("/confirm_reserve")
    public ResultDto confirm_reserve(@RequestParam (required = false)String guestName){
        return reservationService.confirmReserve(guestName);
    }
     //체크인하기
     @PostMapping("/checkin")
     public ResultDto checkin(@RequestParam String guestId){
         return reservationService.checkin(guestId);
     }

    @PostMapping("/checkout")
    public ResultDto checkOut(@RequestParam String status , @RequestParam String guest_id){
        return reservationService.checkout(status, guest_id);
    }
    //예약취소하기
    @PostMapping("/cancel")
    public ResultDto cancel(@RequestParam String guest_id){
        return reservationService.cancel(guest_id);
    }


}
