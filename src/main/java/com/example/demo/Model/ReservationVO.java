package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationVO {

    int id;
    String roomNo;
    String businessNo;
    int bookingId;
    String roomType;
    String roomCode;
    String guestId;
    String guestName;
    String bookingDate;
    String checkIn;
    String checkOut;
    String phone;
    String status;
    int roomPrice;
    int standardPrice;

}
