package com.readme.logic;

import com.readme.logic.helpers.files.FileCommunicator;
import com.readme.logic.helpers.files.FileGeneratorHelper;
import com.readme.logic.helpers.files.FileReaderHelper;
import com.readme.logic.helpers.replacers.ReplacerHelper;
import com.readme.logic.interaction.QuizzerInteract;
import com.readme.logic.utils.FileType;


import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TemplateGenerator {
    public static void generateFile(FileType fileType, String fileName) {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        try {
            fileReaderHelper.loadFile(fileType.getTemplatePath());
            QuizzerInteract quizzerInteract = new QuizzerInteract();

            HashMap<String, String> paramsAndValues = quizzerInteract.askQuestions();
            ReplacerHelper replacerHelper = new ReplacerHelper(paramsAndValues);
            FileGeneratorHelper fileGeneratorHelper = new FileGeneratorHelper();
            Path fileGenerated = fileGeneratorHelper.generate(fileType, fileName);


            FileCommunicator fileCommunicator = new FileCommunicator(fileReaderHelper, fileGeneratorHelper, replacerHelper);

            fileCommunicator.copyFromOriginFileTo(fileGenerated);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateFile(FileType fileType, String fileName, Map<String, String> paramsAndValues) throws IOException {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        fileReaderHelper.loadFile(fileType.getTemplatePath());

        ReplacerHelper replacerHelper = new ReplacerHelper(paramsAndValues);
        FileGeneratorHelper fileGeneratorHelper = new FileGeneratorHelper();
        Path fileGenerated = fileGeneratorHelper.generate(fileType, fileName);


        FileCommunicator fileCommunicator = new FileCommunicator(fileReaderHelper, fileGeneratorHelper, replacerHelper);

        fileCommunicator.copyFromOriginFileTo(fileGenerated);
    }

    public static void generateFile(String templateName, FileType fileType, String fileName, Map<String, String> paramsAndValues) throws IOException {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        fileReaderHelper.loadFile(fileType.getTemplatePath());

        ReplacerHelper replacerHelper = new ReplacerHelper(paramsAndValues);
        FileGeneratorHelper fileGeneratorHelper = new FileGeneratorHelper();
        Path fileGenerated = fileGeneratorHelper.generate(fileType, fileName);


        FileCommunicator fileCommunicator = new FileCommunicator(fileReaderHelper, fileGeneratorHelper, replacerHelper);

        fileCommunicator.copyFromOriginFileTo(fileGenerated);

    }
}
