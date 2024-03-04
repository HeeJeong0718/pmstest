package com.example.demo.Service.impl;

import com.example.demo.Model.*;
import com.example.demo.Service.AmenityService;
import com.example.demo.Service.PaymentService;
import com.example.demo.config.Common;
import com.example.demo.mapper.AmenityMapper;
import com.example.demo.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    final AmenityMapper amenityMapper;

    @Override
    public ResultDto list() {
        ArrayList<AmenityVO> amenityVO = amenityMapper.list();
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(amenityVO)
                .build();

    }


    @Override
    public ArrayList<AmenityVO> selectAmenity() {
        return amenityMapper.list();
    }


    @Override
    public ResultDto amenityInsert(AmenityVO amenityVO) {
        amenityMapper.amenityInsert(amenityVO);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(amenityVO)
                .build();
    }

    @Override
    public AmenityVO amenityDetail2(String itemName) {
        return amenityMapper.amenityDetail(itemName);
    }

    @Override
    public ResultDto amenityUpdate(String businessNo, String itemName, int itemPrice, int stock , String useYn) {
       int result = amenityMapper.amenityUpdate(businessNo, itemName, itemPrice, stock , useYn);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();

    }

    @Override
    public ResultDto amenityDelete(int id) {
        return null;
    }
}
