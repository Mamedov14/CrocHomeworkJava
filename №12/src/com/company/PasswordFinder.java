package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PasswordFinder extends Thread {

    static String hash = "40682260CC011947FC2D0B1A927138C5";
    volatile private char[] word = new char[]{
/*

            'p',
            'a',
            's',
            's',
            'w',
            'r',
            'd'

*/
    };

//    private final String hash;
//
//    public PasswordFinder(String hash) {
//        this.hash = hash;
//    }
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();


    // попытка №2 - это безумие, но ...
    // кажется, что алгоритм работает, но когда будет наеден пароль никто не знает))))))
    // разобраться с потокобезопастностью

    public void find() {

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    for (int m = 0; m < 26; m++) {
                        for (int n = 0; n < 26; n++) {
                            for (int l = 0; l < 26; l++) {
                                for (int t = 0; t < 26; t++) {

                                    synchronized (word) {
                                        word = new char[]{
                                                (char) ('a' + (char) i),
                                                (char) ('a' + (char) j),
                                                (char) ('a' + (char) k),
                                                (char) ('a' + (char) m),
                                                (char) ('a' + (char) n),
                                                (char) ('a' + (char) l),
                                                (char) ('a' + (char) t)
                                        };
                                    }

                                    String password = Arrays.toString(word);
                                    String temp = "passwrd";
                                    System.out.println(password);
                                    if (hashPassword(password).equals(hash)) {
                                        System.out.println(password);
                                        interrupt();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//    public static String findPassword(String p, int length) {
//        return findPassword(p, length, new StringBuilder());
//    }

    public static String findPassword(int length, StringBuilder str) {
        // System.out.println(str);
        // Stop condition, password and trial have same length
        if (length == str.length()) {
            if (hashPassword(str.toString()).equals(hash)) {
                return str.toString();
            } else {
                return "";
            }
        }

        String s;

        for (char c = 'a'; c <= 'z'; c++) {
            // Add a new character to the given prefix
            str.append(c);
            // Try to find a password for the new prefix
            s = findPassword(length, str);
            if (!s.equals("")) {
                return s;
            }
            // Didn't work out, remove the character
            str.deleteCharAt(str.length() - 1);
        }
        // All chars have been tried without success, go up one level
        return "";
    }


    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    public char[] getWord() {
        return word;
    }

    @Override
    public void run() {
        find();
    }


}
