package com.readme.logic.helpers.files;


import com.readme.logic.utils.FileType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileGeneratorHelper {
    public Path generate(FileType fileType, String fileName) {
        if (fileType.toString().equals(FileType.NORMAL.toString())) {

        } else if (fileType.toString().equals(FileType.README.toString())) {
            Path newFile = Paths.get(fileType.getOutputTemplatePath(), fileName);

            if (Files.notExists(newFile)) {
                try {
                    Files.createFile(newFile);
                    return newFile;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return newFile;
        }
        return null;
    }
}
