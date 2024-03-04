package com.example.demo.Service.impl;

import com.example.demo.Model.HotelVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Service.HotelService;
import com.example.demo.config.Common;
import com.example.demo.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    final HotelMapper hotelMapper;

    @Override
    public ResultDto list() {

        ArrayList<HotelVO> hotelVO = hotelMapper.list();
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(hotelVO)
                .build();

    }

    @Override
    //hotel명
    public ResultDto insertHotel(String hotelName,String businessNo, String address, Integer numRooms) {
   // public ResultDto insertHotel(String hotel_name) {
        int result = hotelMapper.insertHotel(hotelName , businessNo, address,numRooms);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(1 == result ? Common.successCode : Common.failCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto detail(int id) {

        HotelVO hotelVO = hotelMapper.detail(id);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(hotelVO)
                .build();
    }

    @Override
    public ResultDto updateHotel(String hotelName,String address,String businessNo,int numRooms) {

       int result =  hotelMapper.update(hotelName, address, businessNo,numRooms);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto delete(int id) {
        hotelMapper.delete(id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }

    @Override
    public ResultDto adjustPoint(String guest_id) {
         hotelMapper.updatePoint(guest_id);
        // hotelMapper.delete(id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }
}
