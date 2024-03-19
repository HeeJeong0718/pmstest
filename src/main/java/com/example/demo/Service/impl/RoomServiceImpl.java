package com.example.demo.Service.impl;

import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomDetailVO;
import com.example.demo.Model.RoomVO;
import com.example.demo.Service.RoomDetailService;
import com.example.demo.Service.RoomService;
import com.example.demo.config.Common;
import com.example.demo.mapper.RoomDetailMapper;
import com.example.demo.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    final RoomMapper roomMapper;
    final RoomDetailService roomDetailService;

    @Override
    public ResultDto list() {

        ArrayList<RoomVO> roomVO = roomMapper.list();
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(roomVO)
                .build();

    }
    @Override
    //hotel명
    public RoomVO selectRoom(String roomCode) {

        //룸 생성 후 생성된 갯수만큼 룸 detail에 인서트
       return roomMapper.selectRoom(roomCode);

    }

    @Override
    //hotel명
    public ResultDto insertRoom(RoomVO roomVO) {

        //룸 생성 후 생성된 갯수만큼 룸 detail에 인서트
        RoomVO resultRoom = roomMapper.insertRoom(roomVO);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(resultRoom)
                .build();
    }

    @Override
    public ResultDto detail(int id) {

        RoomVO roomVO = roomMapper.detail(id);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(roomVO)
                .build();
    }

    @Override
    public ResultDto roomModify(String businessNo, String roomType,String roomCode, int stock) {

       int result =  roomMapper.update(businessNo, roomType, roomCode,stock);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto delete(int id) {
        roomMapper.delete(id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }
}
