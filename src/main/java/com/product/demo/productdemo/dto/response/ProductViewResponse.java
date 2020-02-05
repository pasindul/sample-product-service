package com.product.demo.productdemo.dto.response;


import lombok.Data;

import java.util.Set;

@Data
public class ProductViewResponse {


    private Long id;

    private String name;

    private String description;

    private String content;

    private Set<Comment> comments;

    @Data
    public static class Comment {

        private Long id;

        private String text;

    }
}

