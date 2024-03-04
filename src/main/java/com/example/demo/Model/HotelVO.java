package com.example.demo.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelVO {
    int id;
    String hotelName;
    String businessNo;
    String address;
    int numRooms;
    int likeCnt;
}
