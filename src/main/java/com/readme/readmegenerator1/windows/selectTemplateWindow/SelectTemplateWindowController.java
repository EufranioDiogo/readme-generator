package com.readme.readmegenerator1.windows.selectTemplateWindow;

import com.readme.logic.services.readme.ReadmeReader;
import com.readme.logic.utils.files.ReadmeFileVisitor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SelectTemplateWindowController {
    public VBox mainWindow;

    public void readReadme(MouseEvent mouseEvent) {
        System.out.println("Ola mundo");

        ReadmeReader.extractReadmeParam(ReadmeFileVisitor.readmeSources.get(0));
    }
}
