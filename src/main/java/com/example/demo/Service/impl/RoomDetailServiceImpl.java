package com.example.demo.Service.impl;

import com.example.demo.Model.*;
import com.example.demo.Service.ReservationService;
import com.example.demo.Service.RoomDetailService;
import com.example.demo.Service.RoomService;
import com.example.demo.config.Common;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.mapper.RoomDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RoomDetailServiceImpl implements RoomDetailService {

    final RoomDetailMapper roomDetailMapper;


    @Override
    public ResultDto list() {

        ArrayList<RoomDetailVO> roomDetailVO = roomDetailMapper.list();
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(roomDetailVO)
                .build();

    }

    @Override
    //hotel명
   // public ResultDto roomDetailInsert(String roomNo,String roomCode, String roomStatus) {
    public ResultDto roomDetailInsert(RoomDetailVO roomDetailVO) {

        roomDetailMapper.insertRoomDetail(roomDetailVO);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(roomDetailVO)
                .build();
    }

    @Override
    public ResultDto roomStatusDetail(String roomCode) {

        ArrayList<RoomDetailVO> roomDetailVO = roomDetailMapper.detail(roomCode);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(roomDetailVO)
                .build();
    }

    @Override
    public ResultDto detailModify(String roomStatus) {

        int result =  roomDetailMapper.update(roomStatus);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto delete(int id) {
        roomDetailMapper.delete(id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }


}
