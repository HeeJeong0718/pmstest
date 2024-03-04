package com.example.demo.Model;

import lombok.Data;

@Data
public class BlogResponseDto {
    private int display;
    private Item[] items;

    @Data
    static class Item{
        public String title;
        public String link;
        public String description;
        public String bloggername;
        public String bloggerlink;
        public String postdate;
    }
}
