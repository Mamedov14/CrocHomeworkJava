package com.company;

public class CommentDto {

    private String content;

    public CommentDto(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

}
