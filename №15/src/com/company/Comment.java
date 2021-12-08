package com.company;

public class Comment {

    private String content;
    private int time;

    public Comment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
