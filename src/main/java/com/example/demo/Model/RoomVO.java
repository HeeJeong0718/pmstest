package com.example.demo.Model;

import com.example.demo.config.Utils;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//### Cause: java.lang.IndexOutOfBoundsException: Index: 25, Size: 25
//@NoArgsConstructor
//@AllArgsConstructor 추가
public class RoomVO {
    int id;
    String businessNo;
    String roomType;
    String roomCode;
    int roomPrice;
    String resultPrice;
    int stock;
    String result;

}
