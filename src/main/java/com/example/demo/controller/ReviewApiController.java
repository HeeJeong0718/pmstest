package com.example.demo.controller;


import com.example.demo.Model.ResultDto;
import com.example.demo.Model.ReviewVO;
import com.example.demo.Model.RoomVO;
import com.example.demo.Service.ReviewService;
import com.example.demo.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/review")
public class ReviewApiController {

    private final ReviewService reviewService;

    //리스트
    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto reviewList(){
        return reviewService.list();
    }


    //insert
    @PostMapping("/insert")
    @ResponseBody
    public ResultDto reviewInsert(ReviewVO reviewVO){ //@RequestBody 를 빼주니까 됨

        return reviewService.insertReview(reviewVO);
    }
    //detail
    @PostMapping("/reviewDetail")
    @ResponseBody
    public ResultDto reviewDetail(@RequestParam String guestId){
        return reviewService.detail(guestId);
    }

    @PostMapping("/reviewDetail2")
    @ResponseBody
    public ReviewVO reviewDetail2(@RequestParam String guestId){
        return reviewService.detail2(guestId);
    }


}
