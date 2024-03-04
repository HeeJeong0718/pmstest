package com.example.demo.Service.impl;

import com.example.demo.Model.BoardVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Service.BoardService;
import com.example.demo.config.Common;
import com.example.demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final BoardMapper boardMapper;

    @Override
    public ResultDto list() {
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(boardMapper.listBoard())
                .build();

    }

    @Override
    public ResultDto insertBoardInfo(String name, String contents) {

        int result = boardMapper.insertBoard(name,contents);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(1 == result ? Common.successCode : Common.failCode)
                .data(result)
                .build();
    }

    @Override
    public ResultDto detail(int b_id) {

        BoardVO boardVO = boardMapper.detail(b_id);

        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .data(boardVO)
                .build();
    }

    @Override
    public ResultDto update(int b_id, String name) {
        boardMapper.update(b_id,name);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }

    @Override
    public ResultDto deleteBoard(int b_id) {
        boardMapper.delete(b_id);
        return ResultDto.builder()
                .result(Common.SUCCESS)
                .resultCode(Common.successCode)
                .build();
    }
}
