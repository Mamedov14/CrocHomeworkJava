package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class LogFileVisitor extends SimpleFileVisitor<Path> {

    private final Set<Path> logFiles = new HashSet<>();

    public Set<Path> getLogFiles() {
        return logFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.toFile().getName();
        if (fileName.endsWith(".log") || fileName.endsWith(".trace")) {
            logFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }


}
