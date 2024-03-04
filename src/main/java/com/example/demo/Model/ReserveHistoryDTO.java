package com.example.demo.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReserveHistoryDTO {
    int id;
    String guestId;
    String guestName;
    String roomType;
    String createdDate;
}
