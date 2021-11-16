package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException {

        //создаем список для хранения строк
        List<String> list = new ArrayList<String>();
        // открываем файл
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        //пока файл не пуст – читаем из него
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        String str = "";
        for (String strings : list) {
            System.out.println(Arrays.toString(new String[]{strings}));
        }
        for (String s : list) {
            str = s;
            str.split(" ");
            System.out.println(str);
        }

        //закрываем файл
        reader.close();


    }


}

