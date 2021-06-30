package com.example.entity;

public class Comment extends BaseEntity{
    private Post post;
    private String username;
    private Long userId;
    private String message;
}
