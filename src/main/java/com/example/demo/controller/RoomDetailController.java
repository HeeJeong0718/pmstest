package com.example.demo.controller;

import com.example.demo.Model.*;
import com.example.demo.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.NameNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor

public class RoomDetailController {
    final ReservationService reservationService;

    final PaymentService paymentService;

    final ReviewService reviewService;


    final RoomDetailService roomDetailService;

    final AmenityService amenityService;


    @GetMapping("/reserve") //호텔예약
    public String reserve(Model model) {
        return "reserve";
    }

    @GetMapping("/reserveDetail") //예약상세
    public String reserveDetail(HttpServletRequest request, @RequestParam String guestName , Model model){
        ReservationVO reservationVO = reservationService.reserveDetail2(guestName);
        ArrayList<AmenityVO> amenity = amenityService.selectAmenity();
        model.addAttribute("reservationVO", reservationVO);
        model.addAttribute("amenity", amenity);
        System.out.println("reservationVO:" + reservationVO);
        System.out.println("amenity:" + amenity);
        return "reserveDetail";
    }

    @GetMapping("/paymentDetail") //예약상세
    public String paymentDetail(HttpServletRequest request, @RequestParam String bookingId , Model model){
        PaymentVO paymentVO = paymentService.paymentDetail(bookingId);
        model.addAttribute("paymentVO", paymentVO);
        return "paymentDetail";
    }
    @GetMapping("/roomDetail") //예약상세
    public String roomDetail(HttpServletRequest request, @RequestParam String roomCode , Model model){
        model.addAttribute("roomCode", roomCode);
        System.out.println("roomCode:" + roomCode);
        return "roomDetail";
    }

    @GetMapping("/amenityDetail") //어매니티상세
    public String amenityDetail(HttpServletRequest request, @RequestParam String itemName , Model model){
        AmenityVO amenityVO = amenityService.amenityDetail2(itemName);
        model.addAttribute("amenityVO", amenityVO);
        System.out.println("amenityVO:" + amenityVO);
        return "amenityDetail";
    }

    @GetMapping("/billing") //빌링
    public String billing(HttpServletRequest request, @RequestParam String guestId , Model model){
        model.addAttribute("guestId", guestId);
        System.out.println("guestId:" + guestId);
        return "billing";
    }



    @GetMapping("/roomReview") //고객리뷰 테이블
    public String roomReview(){
        return "roomReview";
    }


    @GetMapping("/reviewDetail") //예약상세
    public String reviewDetail(HttpServletRequest request, @RequestParam String guestId , Model model){
        ReviewVO reviewVO = reviewService.detail2(guestId);
        model.addAttribute("reviewVO", reviewVO);
        model.addAttribute("guestId", guestId);
        System.out.println("reviewVO:" + reviewVO.getTitle());
        return "reviewDetail";
    }





}
