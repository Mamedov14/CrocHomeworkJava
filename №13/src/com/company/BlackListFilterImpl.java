package com.company;

import java.util.*;

public class BlackListFilterImpl implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filterComments = new ArrayList<>();
        for (String comment : comments) {
            for (String blackWord : blackList) {
                if (comment.contains(blackWord)) {
                    System.out.println("Найдено запрещенное слово: " + comment);
                }
            }
        }
    }
}