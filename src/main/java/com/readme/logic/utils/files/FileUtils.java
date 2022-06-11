package com.readme.logic.utils.files;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class FileUtils {
    public static boolean fileExists(Path file) {
        return Files.exists(file);
    }
}
