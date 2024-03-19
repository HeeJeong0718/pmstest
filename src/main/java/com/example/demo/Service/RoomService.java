package com.example.demo.Service;

import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomVO;

public interface RoomService {

     //리스트
     ResultDto list();

     ResultDto insertRoom(RoomVO roomVO);

     RoomVO selectRoom(String roomCode);


     ResultDto detail(int id);

     ResultDto roomModify(String businessNo, String roomType,String roomCode, int stock);

     ResultDto delete(int id);

}
