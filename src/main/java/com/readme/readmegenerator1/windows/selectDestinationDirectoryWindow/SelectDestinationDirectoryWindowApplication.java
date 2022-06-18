package com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow;

import com.readme.logic.TemplateGenerator;
import com.readme.logic.utils.FileType;
import com.readme.readmegenerator1.windows.createNewReadmeWindow.CreateNewReadmeApplication;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class SelectDestinationDirectoryWindowApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(null);
        FXMLLoader fxmlLoader = new FXMLLoader(SelectDestinationDirectoryWindowApplication.class.getResource("select-destination-directory-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        boolean add = scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        // scene.getStylesheets().add("/style.css");

        DirectoryChooser directoryChooser = new DirectoryChooser();
        ImageView directoryChooserButton = (ImageView) scene.lookup("#openDirectoryButton");
        TextField textField = (TextField) scene.lookup("#directoryLocationTextField");


        directoryChooserButton.setOnMouseClicked(event -> {
            var file = directoryChooser.showDialog(stage);

            if (file.exists() && file.canWrite() && file.isDirectory()) {
                Path path = Paths.get(file.getPath());

                textField.setText(file.getPath());
            } else {
                System.out.println("Please enter a valid directory");
            }
        });


        stage.setTitle("Selecting the destination directory window");
        stage.setScene(scene);
        stage.show();
    }
}
