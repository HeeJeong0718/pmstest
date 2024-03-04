package com.example.demo.controller;

import com.example.demo.Model.ResultDto;
import com.example.demo.Service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {

    final ReplyService replyService;

    @CrossOrigin(origins="*")
    @PostMapping("/insert")
    @ResponseBody
    public ResultDto inserReply(@RequestParam (required = false) int b_id, String name, String r_contents ){
        return replyService.insertReply(b_id, name, r_contents);
    }

    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto listReply(@RequestParam (required = false) int b_id){
        return replyService.listReply(b_id);
    }

    @CrossOrigin(origins="*")
    @PostMapping("/detail")
    @ResponseBody
    public ResultDto detailReply(@RequestParam (required = false) int r_id){
        return replyService.detailReply(r_id);
    }

    @CrossOrigin(origins="*")
    @PostMapping("/update")
    @ResponseBody
    public ResultDto updateReply(@RequestParam (required = false) int r_id, String name , String r_contents){
        return replyService.updateReply(r_id,name,r_contents);
    }
    @CrossOrigin(origins="*")
    @PostMapping("/delete")
    @ResponseBody
    public ResultDto deleteReply(@RequestParam (required = false) int r_id){
        return replyService.deleteReply(r_id);
    }

}
