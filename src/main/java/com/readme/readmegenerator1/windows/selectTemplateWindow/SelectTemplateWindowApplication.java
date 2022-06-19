package com.readme.readmegenerator1.windows.selectTemplateWindow;

import com.readme.logic.utils.files.ReadmeFileVisitor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SelectTemplateWindowApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(SelectTemplateWindowApplication.class.getResource("select-template-window.fxml")));

        Path root = Paths.get("./resources");

        Files.walkFileTree(root, new ReadmeFileVisitor());

        System.out.println(ReadmeFileVisitor.readmeSources);
        System.out.println(ReadmeFileVisitor.readmeSources.size());
        stage.setScene(scene);
        stage.setTitle("Select the Template");
        stage.show();
    }
}
