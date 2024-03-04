package com.example.demo.Service;

import com.example.demo.Model.PaymentVO;
import com.example.demo.Model.ResultDto;

public interface PaymentService {

    ResultDto list();

    ResultDto payHotelPrice(String businessNo,int bookingId,String guestId, String payStatus);

    PaymentVO paymentDetail(String bookingId);


}
