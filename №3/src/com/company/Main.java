package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {5, 16, 1, 29, 14};
        System.out.println("Был массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        int max = array[0];
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        int temp;
        temp = array[index];
        array[index] = array[4];
        array[4] = temp;
        for (int j = 0; j < array.length; j++) {
            if (min > array[j]) {
                min = array[j];
                index = j;
            }
        }
        temp = array[index];
        array[index] = array[0];
        array[0] = temp;

        System.out.println("\nСтал массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
