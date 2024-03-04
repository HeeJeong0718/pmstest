package com.example.demo.mapper;

import com.example.demo.Model.HotelVO;
import com.example.demo.Model.RoomDetailVO;
import com.example.demo.Model.RoomVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface RoomDetailMapper {

    //호텔리스트
    ArrayList<RoomDetailVO> list();

    //호텔생성
    int insertRoomDetail(RoomDetailVO roomDetailVO);

    ArrayList<RoomDetailVO> detail(String roomCode);

    int  update(String roomStatus);

    int  delete(int id);
}
