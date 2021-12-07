package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int firstFilmIndex;
        int secondFilmIndex;

        Scanner scanner = new Scanner(System.in);

        System.out.println("введите индексы фильмов: ");
        firstFilmIndex = scanner.nextInt();
        secondFilmIndex = scanner.nextInt();

        SearchRecommendations searchRecommendations = new SearchRecommendations();
        searchRecommendations.checkRecommendations(firstFilmIndex, secondFilmIndex);
    }
}
