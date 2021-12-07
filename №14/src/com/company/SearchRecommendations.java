package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRecommendations {

    private final String PATH_MOVIES = "C:\\Users\\vagif\\IdeaProjects\\№14\\src\\com\\company\\file\\movies.txt";
    private final String PATH_CLIENT = "C:\\Users\\vagif\\IdeaProjects\\№14\\src\\com\\company\\file\\client.txt";


    public SearchRecommendations() {

    }

    public void checkRecommendations(int firstFilmIndex, int secondFilmIndex) throws IOException {

        List<String> movies = getMoviesFromFile();
        List<String> clients = getClientsFromFile();

        /* Предпочтительные фильмы (включая просмотренные) */
        List<String> prefferedMovies = new ArrayList<>();

        // проверка 1 условия
        for (String s : clients) {
            if (s.contains(String.valueOf(firstFilmIndex))
                    || s.contains(String.valueOf(secondFilmIndex))) {
                prefferedMovies.add(s);
            }
        }

        /* Предпочтительные фильмы (не включая просмотренные) */
        List<String> excludedWatchedMovies = new ArrayList<>();

        // проверка 2 условия
        for (String s : prefferedMovies) {
            s = s.replace(String.valueOf(firstFilmIndex), "");
            s = s.replace(String.valueOf(secondFilmIndex), "");
            s = s.replace(",", "");
            excludedWatchedMovies.add(s);
        }
        // вывод с учётом исключеных просмотренных
        System.out.println(excludedWatchedMovies);

        List<Integer> filmCounts = Arrays.asList(0, 0, 0, 0);
        // расчет количество фильмов всех категорий
        for (String excludedWatchedMovie : excludedWatchedMovies) {
            for (int j = 0; j < filmCounts.size(); j++) {
                if (excludedWatchedMovie.contains(Integer.toString(j + 1))) {
                    filmCounts.set(j, filmCounts.get(j) + 1);
                }
            }
        }
        // проверка 3 условия
        int maxCount = filmCounts.get(0);
        int maxIdx = 0;
        for (int i = 0; i < filmCounts.size(); i++) {
            if (filmCounts.get(i) > maxCount) {
                maxCount = filmCounts.get(i);
                maxIdx = i;
            }
        }
        System.out.println(movies.get(maxIdx));
    }


    private List<String> getMoviesFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(PATH_MOVIES));
        List<String> stringArrayList = new ArrayList<>();
        String buffer;
        while ((buffer = br.readLine()) != null) {
            stringArrayList.add(buffer);
        }
        return stringArrayList;
    }

    private List<String> getClientsFromFile() throws IOException {
        List<String> stringArrayList = new ArrayList<>();
        String buffer;
        BufferedReader br = new BufferedReader(new FileReader(PATH_CLIENT));
        while ((buffer = br.readLine()) != null) {
            stringArrayList.add(buffer);
        }
        return stringArrayList;
    }
}
