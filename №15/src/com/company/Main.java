package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> blackList = new HashSet<>();
        blackList.add("stupid");
        blackList.add("fool");

        List<String> strings = List.of(
                "Hello",
                "stupid",
                "fool",
                "men"
        );

        List<Comment> comments = List.of(
                new Comment("HELLO"),
                new Comment("stupid"),
                new Comment("fool"),
                new Comment("men")
        );

        List<CommentDto> commentDtos = List.of(
                new CommentDto("HeLLo"),
                new CommentDto("stupid"),
                new CommentDto("fool"),
                new CommentDto("men")
        );


        BlackListFilter<String> blackListFilterString = new BlackListFilterImpl<>();
        System.out.println(blackListFilterString.filterComments(strings, x -> !blackList.contains(x)));

        BlackListFilter<Comment> blackListFilterComment = new BlackListFilterImpl<>();
        System.out.println(blackListFilterComment.filterComments(comments, x -> !blackList.contains(x.getContent())));

        BlackListFilter<CommentDto> blackListFilterCommentDto = new BlackListFilterImpl<>();
        System.out.println(blackListFilterCommentDto.filterComments(commentDtos, x -> !blackList.contains(x.getContent())));


    }
}
