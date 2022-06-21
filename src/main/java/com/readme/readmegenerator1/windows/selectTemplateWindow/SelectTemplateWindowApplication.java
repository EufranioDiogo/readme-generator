package com.readme.readmegenerator1.windows.selectTemplateWindow;

import com.readme.logic.utils.files.ReadmeFileVisitor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class SelectTemplateWindowApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(SelectTemplateWindowApplication.class.getResource("select-template-window.fxml")));
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        Path root = Paths.get("./resources");

        Files.walkFileTree(root, new ReadmeFileVisitor());



        stage.setScene(scene);
        stage.setTitle("Select the Template");
        stage.show();
    }

    private void generateTemplateViewElements() {

    }
}
