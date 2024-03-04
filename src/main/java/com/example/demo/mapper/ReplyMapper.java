package com.example.demo.mapper;

import com.example.demo.Model.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ReplyMapper {

    int insertReply(int b_id, String name, String r_contents);

    ArrayList<ReplyVO> list(int b_id);

    ReplyVO detailReply(int b_id);

    int update(int r_id, String name, String r_contents);

    int delete(int r_id);
}
