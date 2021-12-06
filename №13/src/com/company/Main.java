package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String comment = "Hello, stupid fool!!!";
        String[] s = comment.split("\s+");
        List<String> commentWords = List.of(s);

        Set<String> blackList = new HashSet<>();
        blackList.add("stupid");
        blackList.add("fool");

        BlackListFilter blackListFilter = new BlackListFilterImpl();
        blackListFilter.filterComments(commentWords, blackList);
    }


}
