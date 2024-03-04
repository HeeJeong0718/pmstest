package com.example.demo.controller;


import com.example.demo.Model.AmenityVO;
import com.example.demo.Model.ResultDto;
import com.example.demo.Model.RoomVO;
import com.example.demo.Service.AmenityService;
import com.example.demo.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/amenity")
public class AmenityApiController {

    private final AmenityService amenityService;

    //리스트
    @CrossOrigin(origins="*")
    @PostMapping("/list")
    @ResponseBody
    public ResultDto amenityList(){
        return amenityService.list();
    }
    //insert
    @PostMapping("/insert")
    @ResponseBody
    public ResultDto amenityInsert(AmenityVO amenityVO){ //@RequestBody 를 빼주니까 됨

        return amenityService.amenityInsert(amenityVO);
    }
    //detail
    @PostMapping("/amenity_detail")
    @ResponseBody
    public AmenityVO amenityDetail(@RequestParam String itemName){
        return amenityService.amenityDetail2(itemName);
    }
    //수정
    @PostMapping("/update")
    @ResponseBody
    public ResultDto amenityUpdate(@RequestParam (required = false) String businessNo,
                                 @RequestParam  (required = false) String itemName,
                                 @RequestParam  (required = false) int itemPrice,
                                 @RequestParam (required = false) int stock,
                                   @RequestParam (required = false) String useYn
                                ){
        return amenityService.amenityUpdate(businessNo,itemName,itemPrice,stock, useYn);
    }
    @PostMapping("/delete")
    @ResponseBody
    public ResultDto amenityDelete(int id){
        return amenityService.amenityDelete(id);
    }

}
