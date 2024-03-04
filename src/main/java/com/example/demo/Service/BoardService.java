package com.example.demo.Service;

import com.example.demo.Model.ResultDto;

public interface BoardService {

    ResultDto list();
    //service에서는 resultDto mapper에서는 여러개는 arrayList로 감싸서보낸다

    //insert
    ResultDto insertBoardInfo(String name, String contents);

    ResultDto detail(int b_id);


    ResultDto update(int b_id ,String name);

    ResultDto deleteBoard(int b_id);
}
