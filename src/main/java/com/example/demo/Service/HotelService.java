package com.example.demo.Service;

import com.example.demo.Model.BlogResponseDto;
import com.example.demo.Model.ResultDto;
import org.apache.ibatis.annotations.Param;

public interface HotelService {

     //리스트
     ResultDto list();

     ResultDto insertHotel(String hotelName,String businessNo, String address, Integer numRooms);
     //ResultDto insertHotel(String hotel_name);

     ResultDto detail(int id);

     ResultDto updateHotel(String hotelName,String address,String businessNo,int numRooms);

     ResultDto delete(int id);

     ResultDto adjustPoint(String guest_id);

}
