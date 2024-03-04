package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewVO {
    int id;
    String businessNo;
    String roomNo;
    String guestId;
    String guestNm;
    String checkIn;
    String checkOut;
    String createDate;
    String updateDate;
    String email;
    String title;
    String content;

}
