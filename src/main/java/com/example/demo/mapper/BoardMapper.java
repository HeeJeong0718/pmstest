package com.example.demo.mapper;

import com.example.demo.Model.BoardVO;
import com.example.demo.Model.PetVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface BoardMapper {

    int insertBoard(String name, String contents);

    //ResultDto listPet();
    ArrayList<BoardVO> listBoard();

    BoardVO detail(int b_id);

    int  update(int b_id , String name);

    int  delete(int b_id);
}
