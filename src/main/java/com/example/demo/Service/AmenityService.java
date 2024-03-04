package com.example.demo.Service;

import com.example.demo.Model.AmenityVO;
import com.example.demo.Model.PaymentVO;
import com.example.demo.Model.ResultDto;

import java.util.ArrayList;

public interface AmenityService {

    ResultDto list();

    ArrayList<AmenityVO> selectAmenity();

    ResultDto amenityInsert(AmenityVO amenityVO);


    //ResultDto amenityDetail(String itemName);

    AmenityVO amenityDetail2(String itemName);

    ResultDto amenityUpdate(String businessNo,String itemName,int itemPrice,int stock ,String useYn);

    ResultDto amenityDelete(int id);


}
