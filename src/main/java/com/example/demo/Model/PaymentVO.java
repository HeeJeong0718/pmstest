package com.example.demo.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentVO {
    int id;
    int bookingId;
    String businessNo;
    String guestId;
    String payStatus;
    int roomPrice;
    int roomNo;
}
