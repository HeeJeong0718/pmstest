package com.example.demo.Model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//index out of bounce 이런거 나오면 @All, @No 추가해주면됨
public class RoomDetailVO {
    int id;
    String businessNo;
    String roomType;
    String roomNo;
    String roomCode;
    String roomStatus;
    int stock;
    int roomPrice; //네고가격
    int standardPrice; //기본가격

}
