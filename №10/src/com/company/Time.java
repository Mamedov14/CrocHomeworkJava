package com.company;

public class Time {

    private int start;
    private int end;

    public Time(int start, int end) {
//        if (start < end) {
//            throw new IllegalArgumentException("Конце не может быть больше начала!");
//        }
        this.start = start;
        this.end = end;
    }


    public int getStart() {
        return start;
    }


    public int getEnd() {
        return end;
    }

    public boolean hasCrossWith(Time other) {
        return this.start <= other.getStart() && this.end >= other.getEnd();
    }

}
