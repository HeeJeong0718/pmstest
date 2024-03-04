package com.example.demo.mapper;

import com.example.demo.Model.BoardVO;
import com.example.demo.Model.ReservationVO;
import com.example.demo.Model.ReserveHistoryDTO;
import com.example.demo.Model.RoomVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Mapper
@Repository
public interface ReservationMapper {

    ArrayList<ReservationVO> reserveList();

    ArrayList<RoomVO> showRoom();

    int reserve(ReservationVO reservationVO);

    ReservationVO reserve2(ReservationVO reservationVO);

    int  checkin(String guestId);

    int confirmReserve(String guestName);

    Integer  checkRoomCnt(String guestName);

    ReservationVO  reserveDetail(String guestName);

    RoomVO selectAvailableRoom();

    RoomVO selectedRoom(Integer id);
    ReservationVO  reservedRoom(@Param("guestId") String guestId);

    ReservationVO  reserveDetail2(String guestName);

    int  checkout(String status, String guest_id);

    int cancel(ReservationVO cancelReserve, String guest_id);

    int insertHistory(ReserveHistoryDTO reserveHistoryDTO);
}
