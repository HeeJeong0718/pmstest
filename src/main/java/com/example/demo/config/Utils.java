package com.example.demo.config;

import java.text.DecimalFormat;

public class Utils {


    public static String setCntComma(int price){
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(price);
    }

}
