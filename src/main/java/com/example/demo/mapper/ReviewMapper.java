package com.example.demo.mapper;

import com.example.demo.Model.PaymentVO;
import com.example.demo.Model.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ReviewMapper {

    ArrayList<ReviewVO> list();

    int insertReview(ReviewVO reviewVO);

    ReviewVO detail(@Param("guestId") String guestId);

    ReviewVO detail2(@Param("guestId") String guestId);




}
