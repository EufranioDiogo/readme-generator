package com.readme.logic.services.readme;

import java.io.*;
import java.nio.file.Path;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReadmeReader {
    public static NavigableSet<ReadmeParam> extractReadmeParam(Path file) {
        NavigableSet<ReadmeParam> readmeParamSet = new TreeSet<>();

        try (
                FileReader fileReader = new FileReader(file.toFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            var i = 1;

            for (String line : bufferedReader.lines().collect(Collectors.toList())) {
                String regex = ".*\\$.*\\$.*\\$.*\\$.*";
                Pattern pattern1 = Pattern.compile(regex);
                Matcher matcher = pattern1.matcher(line);

                if (matcher.matches()) {
                    String resultParam = line.substring(line.indexOf("$"), matcher.end());
                    readmeParamSet.add(new ReadmeParam(resultParam, i));
                }
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readmeParamSet;
    }
}
