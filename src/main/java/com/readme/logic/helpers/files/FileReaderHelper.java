package com.readme.logic.helpers.files;

import com.readme.logic.interfaces.helpers.files.FileReaderInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderHelper implements FileReaderInterface {
    private BufferedReader bufferedReader;
    private Path file;

    public FileReaderHelper() {
    }


    @Override
    public void loadFile(Path file) throws IOException {
        if (Files.notExists(file)) {
            throw new RuntimeException("File to load doesn't exists");
        }
        this.file = file;
    }

    @Override
    public void closeFile() {
        this.file = null;
    }


    @Override
    public String readLine() throws IOException {
        if (this.bufferedReader == null) {
            FileReader fileReader = new FileReader(file.toString());
            this.bufferedReader = new BufferedReader(fileReader);
        }

        String line = this.bufferedReader.readLine();

        if (line == null) {
            this.bufferedReader.close();
        }

        return line;
    }

    public Path getFile() {
        return file;
    }
}
