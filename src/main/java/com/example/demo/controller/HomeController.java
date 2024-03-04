package com.example.demo.controller;

import com.example.demo.Model.LoginDTO;
import com.example.demo.Model.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class HomeController {
    //1.검색하면 해당 데이터 나오게 우선 뿌려보자
    @GetMapping("/")
    public String main() {
        return "index";
      /*  System.out.println("name" + name);
        if(name != null){
            model.addAttribute("name",name);
            return "index";
        }else{
            return "redirect:/login";
        }*/
    }
    //메인페이지
   /* @GetMapping("/main")
    public String index(@CookieValue(name="name", required=false)String name, Model model) {
        System.out.println("name" + name);
        if(name != null){
            model.addAttribute("name",name);
            return "index";
        }else{
            return "redirect:/login";
        }
    }*/

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }


    @GetMapping("/myPage")
    public String myPage(){
        return "myPage";
    }


    @GetMapping("/blank")
    public String blank(){
        return "blank";
    }

    @GetMapping("/reservationList")
    public String table(){
        return "reservationList";
    }

    @GetMapping("/checkin_list")
    public String checkInList(){
        return "checkInList";
    }

    @GetMapping("/payment_list")
    public String paymentList(){
        return "paymentList";
    }


    @GetMapping("/room_setting")
    public String roomSetting(){
        return "room_setting";
    }

    @GetMapping("/reviewform")
    public String reviewform(){
        return "reviewform";
    }

    @GetMapping("/amenity")  //amenity 만들기
    public String amenity(){
        return "amenity";
    }


    @GetMapping("/login")  //amenity 만들기
    public String login(){
        return "login";
    }



   /* @GetMapping("/reserveDetail") //호텔예약폼
    public String reserveDetail(HttpServletRequest request, @RequestParam String guestName){
        System.out.println("guestName:" + guestName);
        request.getParameter(guestName);
        System.out.println("guestName222:" + guestName);
        return "reserveDetail";
    }*/
}
