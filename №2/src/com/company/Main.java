package com.company;

public class Main {
    static public void printBytes(double bytes) {
        if (bytes < 1024) {
            System.out.println(bytes + " B");
        } else if (bytes >= 1024 && bytes < 1048576) {
            bytes = bytes / 1024;
            System.out.println(bytes + " KB");
        } else if (bytes >= 1048576 && bytes < 1073741824) {
            bytes = bytes / 1024 / 1024;
            System.out.println(bytes + " MB");
        } else if (bytes >= 1073741824 && bytes < 1099511627776.) {
            bytes = bytes / (1024 * 1024 * 1024);
            System.out.println(bytes + " GB");
        } else {
            bytes = bytes / (1024. * 1024 * 1024 * 1024);
            System.out.println(bytes + " TB");
        }
    }


    public static void main(String[] args) {
        printBytes(1024);
        printBytes(24);
        printBytes(25625463);
        printBytes(108551365776.);
        printBytes(53692044905543.);
    }
}
