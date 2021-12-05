package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    // 40682260CC011947FC2D0B1A927138C5
    // пароль состоит из латинских 7 букв, все строчные


    static String hash = "40682260CC011947FC2D0B1A927138C5";

    public static void main(String[] args) throws InterruptedException {

        PasswordFinder passwordFinder1 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder2 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder3 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder4 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder5 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder6 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder7 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder8 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder9 = new PasswordFinder(args[0]);
        PasswordFinder passwordFinder10 = new PasswordFinder(args[0]);

        passwordFinder1.start();
        passwordFinder2.start();
        passwordFinder3.start();
        passwordFinder4.start();
        passwordFinder5.start();
        passwordFinder6.start();
        passwordFinder7.start();
        passwordFinder8.start();
        passwordFinder9.start();
        passwordFinder10.start();

    }

/*

        while (true) {
            password = wordRandom();
            System.out.println(password);
            if (hashPassword(password).equals(args[0])) {
                System.out.println(password);
                break;
            }
        }

*/

    // попытка №1 - не удалась))
    public static String randomWord() {
        Random random = new Random();
        StringBuilder word = new StringBuilder(7);
        for (int i = 0; i < 7; i++) {
            word.append((char) ('a' + random.nextInt(26)));
        }
        return word.toString();
    }

}
