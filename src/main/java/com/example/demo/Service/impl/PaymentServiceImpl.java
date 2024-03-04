package com.example.demo.Service.impl;

import com.example.demo.Model.MemberDtailVO;
import com.example.demo.Model.PayStatus;
import com.example.demo.Model.PaymentVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Service.PaymentService;
import com.example.demo.config.Common;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    final PaymentMapper paymentMapper;

    @Override
    public ResultDto list() {
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(paymentMapper.list())
                .build();
    }

    @Override
    public PaymentVO paymentDetail(String bookingId) {
        return paymentMapper.paymentDetail(bookingId);
    }

    //지불하기
    @Override
    public ResultDto payHotelPrice(String businessNo,int bookingId, String guestId, String payStatus) {

        PaymentVO paymentVO = PaymentVO.builder()
                .businessNo(businessNo)
                .bookingId(bookingId)
                .guestId(guestId)
                .payStatus(PayStatus.PAYDONE.getCode())
                .build();

        //결제금액
        int price =10000;
        //포인트 : 결제금액의 2퍼
        double point = price * 0.2;


        int result = paymentMapper.processPay(paymentVO);

        //응답값::
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(result)
                .build();

    }


}
