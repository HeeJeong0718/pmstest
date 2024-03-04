package com.example.demo.Service;

import com.example.demo.Model.HotelVO;
import com.example.demo.Model.ReservationVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomVO;

public interface ReservationService {

     //리스트
     ResultDto reserveList();

     ResultDto showRoom();

     ResultDto showSelectedRoom(Integer id);

     ResultDto reserve(String guestId,String guestName,String bookingDate,String checkIn,String checkOut, String phone, String roomType);
     ResultDto reserve2(ReservationVO reservationVO);


     ResultDto reserveDetail(String guestName);

     ResultDto confirmReserve(String guestName);

     ReservationVO reserveDetail2(String guestName);

     RoomVO selectAvailableRoom();

     ResultDto checkin(String guestId);

     ResultDto cancel(String guest_id);
     ResultDto checkout(String status, String guest_id);



}
