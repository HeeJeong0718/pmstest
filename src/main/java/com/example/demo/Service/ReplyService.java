package com.example.demo.Service;

import com.example.demo.Model.ReplyVO;
import com.example.demo.Model.ResultDto;

import java.util.ArrayList;

public interface ReplyService {

    ResultDto insertReply(int b_id, String name, String r_contents);

    ResultDto listReply(int b_id);

    ResultDto detailReply(int r_id);

    ResultDto updateReply(int r_id,String name, String r_contents);

    ResultDto deleteReply(int r_id);
}
