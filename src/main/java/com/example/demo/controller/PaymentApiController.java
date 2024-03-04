package com.example.demo.controller;


import com.example.demo.Model.ResultDto;
import com.example.demo.Service.HotelService;
import com.example.demo.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/payment")
public class PaymentApiController {

    private final PaymentService paymentService;

    //리스트
    @CrossOrigin(origins="*")
    @PostMapping("/paylist")
    @ResponseBody
    public ResultDto paymentList(){
        return paymentService.list();
    }


    //결제하기
    @PostMapping("/payHotelPrice")
    @ResponseBody
    public ResultDto payHotelPrice(
                                 @RequestParam (required = false) String businessNo,
                                 @RequestParam (required = false) int bookingId,
                                 @RequestParam (required = false) String guestId,
                                 @RequestParam (required = false) String payStatus
                                 ){
        return paymentService.payHotelPrice(businessNo,bookingId,guestId,payStatus);
    }



}
