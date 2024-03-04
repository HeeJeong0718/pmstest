package com.example.demo.controller;

import com.example.demo.Model.ResultDto;
import com.example.demo.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/board")
@RequiredArgsConstructor

public class BoardApiController {

    final BoardService boardService;

    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto boardList() {
        return boardService.list();
    }

    //펫 작성
    @CrossOrigin(origins="*")
    @PostMapping(value ="/insert")
    @ResponseBody
    public ResultDto insertBoard(@RequestParam (required = false) String name ,@RequestParam String contents){
        return boardService.insertBoardInfo(name,contents);
    }

    //상세
    @CrossOrigin(origins="*")
    @PostMapping(value ="/detail")
    @ResponseBody
    public ResultDto detailBoard(@RequestParam (required = false) int b_id){
        return boardService.detail(b_id);
    }
   //수정
   @CrossOrigin(origins="*")
   @PostMapping(value ="/update")
   @ResponseBody
   public ResultDto updateBoard(@RequestParam (required = false) int b_id, @RequestParam String name){
       return boardService.update(b_id,name);
   }
   //삭제
   @CrossOrigin(origins="*")
   @PostMapping(value ="/delete")
   @ResponseBody
   public ResultDto deleteBoard(@RequestParam (required = false) int b_id){
       return boardService.deleteBoard(b_id);
   }
}
