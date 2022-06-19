package com.readme.logic.utils.files;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadmeFileVisitor extends SimpleFileVisitor<Path> {
    public static final List<Path> readmeSources = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String regex = "([a-zA-Z\\d])+\\.md";
        Pattern pattern1 = Pattern.compile(regex);
        Matcher matcher = pattern1.matcher(file.getFileName().toString());

        if (matcher.matches()) {
            ReadmeFileVisitor.readmeSources.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

}
