package com.company;

public class LodEntry implements Comparable<LodEntry> {

    long time;
    String message;


    public LodEntry(String nextLine) {
        String[] strings = nextLine.split("\s+");
        time = Long.parseLong(strings[0]);
        message = strings[1];
    }


    @Override
    public int compareTo(LodEntry lodEntry) {
        return Long.compare(this.time, lodEntry.time);
    }

    @Override
    public String toString() {
        return "LodEntry{" +
                "time=" + time +
                ", message='" + message + '\'' +
                '}';
    }
}
