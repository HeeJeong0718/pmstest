package com.example.demo.Service.impl;

import com.example.demo.Model.*;
import com.example.demo.Service.HotelService;
import com.example.demo.Service.PaymentService;
import com.example.demo.Service.ReservationService;
import com.example.demo.config.Common;
import com.example.demo.config.Utils;
import com.example.demo.mapper.PaymentMapper;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    final ReservationMapper reservationMapper;
    final RoomMapper roomMapper;

    final PaymentMapper paymentMapper;


    @Override
    public RoomVO selectAvailableRoom() {

        return reservationMapper.selectAvailableRoom();
    }

    @Override
    public ResultDto showRoom() {

        ArrayList<RoomVO> room = reservationMapper.showRoom();
        for (RoomVO rm : room) {
            rm.setResultPrice(Utils.setCntComma(rm.getRoomPrice()));
        }

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(room)
                .build();
    }

    @Override
    public ResultDto showSelectedRoom(Integer id) {
       RoomVO room = reservationMapper.selectedRoom(id);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(room)
                .build();
    }



    @Override
    public ResultDto reserveList() {

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(reservationMapper.reserveList())
                .build();

    }




    @Override
    public ResultDto reserve(String guestId,String guestName,String bookingDate,String checkIn,String checkOut, String phone, String roomType) {

        ReservationVO reservationVO = ReservationVO.builder()
                .businessNo("testHotel")
                .bookingId(2)
                .guestId("guest_id")
                .guestName(guestName)
                .bookingDate("2023-11-01")
                .checkIn("2023-11-01")
                .checkOut("2023-11-01")
                .phone("111111")
                .status(ReservationStatus.BOOKING.getCode())
                .roomType(roomType)
                .build();

         int result =   reservationMapper.reserve(reservationVO);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();

    }
    @Override
    public ResultDto reserve2(ReservationVO reservationVO) {

        int result =   reservationMapper.reserve(reservationVO);


        if(result == 1){
            //재고 차감
            ReservationVO reservationDetail = reservationMapper.reserveDetail(reservationVO.getGuestName());
            //재고 파악 후 예약상태 업데이트 해야함
            //손님이 예약한 룸의 현재 재고 들고오기
            int checkReserveRoomCnt = reservationMapper.checkRoomCnt(reservationVO.getGuestName());
            System.out.println("checkReserveRoomCnt :"  + checkReserveRoomCnt);
            RoomVO roomVO = roomMapper.currentRoomCnt(reservationDetail.getRoomCode() , reservationDetail.getBusinessNo());
            int currentStock = roomVO.getStock();
            System.out.println("currentStock :"  + currentStock);
            int stock = currentStock - checkReserveRoomCnt;
            //int stock = 0;
            System.out.println("finalStock :"  + stock);

            int success = roomMapper.updateRoomStock(stock, reservationDetail.getRoomCode(), reservationDetail.getBusinessNo());

        }


        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();
    }



    @Override
    public ResultDto checkin(String guestId) {

        int result = reservationMapper.checkin(guestId);

        ReservationVO reservationVO = reservationMapper.reservedRoom(guestId);

        //결제예정금액 생성
        if(result == 1){
            PaymentVO paymentVO = PaymentVO.builder()
                    .bookingId(reservationVO.getBookingId())
                    .businessNo(reservationVO.getBusinessNo())
                    .guestId(guestId)
                    .roomNo(Integer.parseInt(reservationVO.getRoomNo()))
                    .payStatus(PayStatus.NOTPAY.getCode())
                    .roomPrice(reservationVO.getStandardPrice())
                    .build();

            int success = paymentMapper.processPay(paymentVO);

            return ResultDto.builder()
                    .result(Common.SUCCESS)
                    .resultCode(Common.successCode)
                    //.data(result)
                    .build();

        }

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto reserveDetail(String guestName) {

        ReservationVO reservationDetail =  reservationMapper.reserveDetail(guestName);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(reservationDetail)
                .build();
    }

    @Override
    public ResultDto confirmReserve(String guestName) {

        ReservationVO reservationDetail = reservationMapper.reserveDetail(guestName);
        //재고 파악 후 예약상태 업데이트 해야함
        //손님이 예약한 룸의 현재 재고 들고오기
        int checkReserveRoomCnt = reservationMapper.checkRoomCnt(guestName);
        System.out.println("checkReserveRoomCnt :"  + checkReserveRoomCnt);
        RoomVO roomVO = roomMapper.currentRoomCnt(reservationDetail.getRoomCode() , reservationDetail.getBusinessNo());
        int currentStock = roomVO.getStock();
        System.out.println("currentStock :"  + currentStock);
        int stock = currentStock - checkReserveRoomCnt;
        //int stock = 0;
        System.out.println("finalStock :"  + stock);

           int success = roomMapper.updateRoomStock(stock, reservationDetail.getRoomCode(), reservationDetail.getBusinessNo());
            if(success == 1){
                int result =  reservationMapper.confirmReserve(guestName);
            }
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
              //  .data(reservationDetail)
                .build();
    }


    @Override
    public ReservationVO reserveDetail2(String guestName) {

        return  reservationMapper.reserveDetail2(guestName);
    }


    @Override
    public ResultDto checkout(String staus , String guest_id) {

        int result = reservationMapper.checkout(staus,guest_id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }

    //결제하지 않은 상태면 취소가능
    @Override
    //cancel
    public ResultDto cancel(String guest_id) {

        ReservationVO cancelReseve = ReservationVO.builder()
                .guestId(null)
                .guestName(null)
                .bookingDate(null)
                .checkIn(null)
                .checkOut(null)
                .phone(null)
                .status(ReservationStatus.NON_BOOKING.getCode())
                .build();

        int result = reservationMapper.cancel(cancelReseve,guest_id);

        if(result == 1){
            ReserveHistoryDTO insertHistoryDTO = ReserveHistoryDTO.builder()
                    .guestName(cancelReseve.getGuestName())
                    .roomType("single")
                    .createdDate("2023-10-11")
                    .build();

             reservationMapper.insertHistory(insertHistoryDTO);
        }

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }





}
