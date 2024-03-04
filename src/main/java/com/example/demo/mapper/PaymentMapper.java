package com.example.demo.mapper;

import com.example.demo.Model.MemberDtailVO;
import com.example.demo.Model.MemberVO;
import com.example.demo.Model.PaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface PaymentMapper {

    ArrayList<PaymentVO> list();

    int processPay(PaymentVO paymentVO);

    PaymentVO paymentDetail(@Param("bookingId") String bookingId);





}
