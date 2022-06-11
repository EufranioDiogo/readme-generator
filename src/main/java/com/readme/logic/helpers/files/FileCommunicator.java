package com.readme.logic.helpers.files;

import com.readme.logic.helpers.replacers.ReplacerHelper;
import com.readme.logic.interfaces.helpers.files.FileCommunicatorInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCommunicator implements FileCommunicatorInterface {
    FileReaderHelper fileReaderHelper;
    FileGeneratorHelper fileGeneratorHelper;
    ReplacerHelper replacerHelper;

    public FileCommunicator(FileReaderHelper fileReaderHelper, FileGeneratorHelper fileGeneratorHelper, ReplacerHelper replacerHelper) {
        this.fileReaderHelper = fileReaderHelper;
        this.fileGeneratorHelper = fileGeneratorHelper;
        this.replacerHelper = replacerHelper;
    }

    @Override
    public boolean copyFromOriginFileTo(Path destFile) {
        if (Files.notExists(destFile)) {
            throw new RuntimeException("File to generate doesn't exists");
        }

        try (
                FileWriter fileWriter = new FileWriter(destFile.toString());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            String line;

            while ((line = fileReaderHelper.readLine()) != null) {
                line = replacerHelper.replace(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
