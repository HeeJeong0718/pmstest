package com.example.demo.mapper;

import com.example.demo.Model.HotelVO;
import com.example.demo.Model.RoomVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface RoomMapper {

    //호텔리스트
    ArrayList<RoomVO> list();

    RoomVO selectRoom(String roomCode);

    //호텔생성
    RoomVO insertRoom(RoomVO roomVO);

    RoomVO detail(int id);

    RoomVO currentRoomCnt(@Param("roomCode")String roomCode,@Param("businessNo") String businessNo);

    //dto로 안보낼때는 @Param을 넣어줘야함
    int updateRoomStock(@Param("stock") int stock , @Param("roomCode") String roomCode, @Param("businessNo") String businessNo);


    int  update(String businessNo,String roomType, String roomCode, int stock);

    int  delete(int id);
}
