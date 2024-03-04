package com.example.demo.Service;

import com.example.demo.Model.ResultDto;
import com.example.demo.Model.ReviewVO;
import com.example.demo.Model.RoomVO;

public interface ReviewService {

     //리스트
     ResultDto list();

     ResultDto insertReview(ReviewVO reviewVO);


     ResultDto detail(String geustId);

     ReviewVO detail2(String geustId);


}
