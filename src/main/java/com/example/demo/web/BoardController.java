package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/board")
    public String boardList(){
        return "boardList";
    }
    @GetMapping("/insert")
    public String boardInsert(){
        return "board_form";
    }

    @GetMapping("/detail")
    public String boardDetail(){
        return "board_detail";
    }

}
