package com.example.demo.Service.impl;

import com.example.demo.Model.ReplyVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Service.ReplyService;
import com.example.demo.config.Common;
import com.example.demo.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    final ReplyMapper replyMapper;

    @Override
    public ResultDto insertReply(int b_id, String name, String r_contents) {
        replyMapper.insertReply(b_id,name,r_contents);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }

    @Override
    public ResultDto listReply(int b_id) {
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(replyMapper.list(b_id))
                .build();
    }

    @Override
    public ResultDto detailReply(int r_id) {
       ReplyVO replyVO =  replyMapper.detailReply(r_id);
       return  ResultDto.builder()
               .result(Common.SUCCESS)
               .resultCode(Common.successCode)
               .data(replyVO)
               .build();
    }

    @Override
    public ResultDto updateReply(int r_id, String name, String r_contents) {
        replyMapper.update(r_id,name,r_contents);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }

    @Override
    public ResultDto deleteReply(int r_id) {
        replyMapper.delete(r_id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }
}
