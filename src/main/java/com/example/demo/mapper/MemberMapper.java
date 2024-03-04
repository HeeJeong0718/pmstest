package com.example.demo.mapper;

import com.example.demo.Model.MemberDtailVO;
import com.example.demo.Model.MemberVO;
import com.example.demo.Model.ResultDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface MemberMapper {

    MemberDtailVO selectMemberInfo(int id);

    ArrayList<MemberVO> list();

    int insertMember(String user_nm, String pwd, String email);





}
