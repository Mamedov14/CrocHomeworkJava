package com.company;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PasswordFinder extends Thread {


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

    private final String hash;
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    public PasswordFinder(String hash) {
        this.hash = hash;
    }


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
                                    // String temp = "passwrd";
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
