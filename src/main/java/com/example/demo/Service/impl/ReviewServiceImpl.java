package com.example.demo.Service.impl;

import com.example.demo.Model.ResultDto;
import com.example.demo.Model.ReviewVO;
import com.example.demo.Model.RoomVO;
import com.example.demo.Service.ReviewService;
import com.example.demo.Service.RoomDetailService;
import com.example.demo.Service.RoomService;
import com.example.demo.config.Common;
import com.example.demo.mapper.ReviewMapper;
import com.example.demo.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sound.sampled.ReverbType;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    final ReviewMapper reviewMapper;


    @Override
    public ResultDto list() {

        ArrayList<ReviewVO> reviewVO = reviewMapper.list();
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(reviewVO)
                .build();

    }

    @Override
    //hotel명
    public ResultDto insertReview(ReviewVO reviewVO) {

        int result = reviewMapper.insertReview(reviewVO);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto detail(String guestId) {

        ReviewVO reviewVO = reviewMapper.detail(guestId);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(reviewVO)
                .build();
    }
    @Override
    public ReviewVO detail2(String guestId) {

        return reviewMapper.detail2(guestId);

    }
}
