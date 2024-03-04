package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmenityVO {
    int id;
    String businessNo;
    String itemName;
    int itemPrice;
    int stock;
    String useYn;
}
