package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter(
                "C:\\Users\\vagif\\IdeaProjects\\№19\\src\\com\\company\\hello.txt", false)) {

            fileWriter.write("Hello, World!");
            fileWriter.flush();
            
        } catch (IOException ex) {
            System.out.println("Error!");
        }

    }
}
