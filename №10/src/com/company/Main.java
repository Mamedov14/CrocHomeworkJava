package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
// первое решение.
        Time log1 = new Time(1, 12);
        Time log2 = new Time(4, 6);
        Time log3 = new Time(7, 12);
        Time log4 = new Time(10, 32);
        Time log5 = new Time(15, 30);


        int[] startTime = new int[]{
                log1.getStart(), log2.getStart(), log3.getStart(), log4.getStart(), log5.getStart()
        };
        int[] endTime = new int[]{
                log1.getEnd(), log2.getEnd(), log3.getEnd(), log4.getEnd(), log5.getEnd()
        };

        int maxCount = 1;
        for (int i = 0; i < startTime.length; i++) {
            for (int j = 0; j < startTime.length - 1; j++) {
                if ((startTime[i] < startTime[j + 1] && startTime[j + 1] < endTime[i]) &&
                        (startTime[i] < endTime[j + 1] && endTime[j + 1] < endTime[i])) {
                    maxCount++;
                }
            }
        }
        System.out.println(maxCount);


// второе решение.
        List<Time> times = List.of(log1, log2, log3, log4, log5);

        maxCount = 0;
        for (Time time1 : times) {
            int currentCount = 0;
            for (Time time2 : times) {
                if (time1.hasCrossWith(time2)) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }

        System.out.println(maxCount);
    }
}
