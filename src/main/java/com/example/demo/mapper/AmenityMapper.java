package com.example.demo.mapper;

import com.example.demo.Model.AmenityVO;
import com.example.demo.Model.PaymentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface AmenityMapper {

    ArrayList<AmenityVO> list();

    ArrayList<AmenityVO> selectAmenity();

    int amenityInsert(AmenityVO amenityVO);


    AmenityVO amenityDetail(@Param("itemName") String itemName);

    int amenityUpdate (@Param("businessNo") String businessNo, @Param("itemName")String itemName, @Param("itemPrice")int itemPrice,@Param("stock")  int stock , @Param("useYn") String useYn);

    int amenityDelete(int id);

}
