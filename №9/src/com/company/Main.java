package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        LogFileVisitor logFileVisitor = new LogFileVisitor();
        Files.walkFileTree(Path.of(args[0]), logFileVisitor);
        Set<Scanner> scannerSet = new HashSet<>();
        for (Path path : logFileVisitor.getLogFiles()) {
            scannerSet.add(new Scanner(path));
        }

        SortedSet<LodEntry> entries = new TreeSet<>();

        while (true) {
            for (Iterator<Scanner> s = scannerSet.iterator(); s.hasNext(); ) {
                Scanner scanner = s.next();
                if (scanner.hasNextLine()) {
                    entries.add(new LodEntry(scanner.nextLine()));
                } else {
                    s.remove();
                }
            }

            LodEntry first = entries.first();
            System.out.println(first);
            entries.remove(first);
            if (entries.isEmpty()) {
                break;
            }
        }

    }
}
