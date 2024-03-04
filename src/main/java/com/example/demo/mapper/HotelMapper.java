package com.example.demo.mapper;

import com.example.demo.Model.HotelVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface HotelMapper {

    //호텔리스트
    ArrayList<HotelVO> list();

    //호텔생성
    int insertHotel(String hotelName,String businessNo, String address, Integer numRooms);
    //int insertHotel(String hotel_name);
    HotelVO detail(int id);

    int  update(String hotelName,String  address,String  businessNo,int numRooms);

    int  delete(int id);

    int updatePoint(String guest_id);
}
