package com.company;

import java.util.Collection;
import java.util.function.Predicate;


public interface BlackListFilter<T> {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     */

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */

    default Collection<T> filterComments(Collection<T> comments, Predicate<T> predicate) {
        return comments.stream().filter(predicate).toList();
    }
}


