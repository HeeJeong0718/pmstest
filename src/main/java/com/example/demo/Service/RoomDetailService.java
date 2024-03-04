package com.example.demo.Service;

import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomDetailVO;

import java.util.ArrayList;

public interface RoomDetailService {

     //리스트
     ResultDto list();

     ResultDto roomDetailInsert(RoomDetailVO roomDetailVO);


     ResultDto roomStatusDetail(String roomCode);

     ResultDto detailModify(String roomStatus);

     ResultDto delete(int id);

}
