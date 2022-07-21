package com.readme.readmegenerator1.windows.createNewReadmeWindow;

import com.readme.readmegenerator1.MainApplication;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class CreateNewReadmeApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(null);
        FXMLLoader fxmlLoader = new FXMLLoader(CreateNewReadmeApplication.class.getResource("create-new-readme-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        boolean add = scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        // scene.getStylesheets().add("/style.css");


        stage.setTitle("Creating your README");
        stage.setScene(scene);
        stage.show();

        ComboBox liceComboBox = (ComboBox) scene.lookup("#licenseParamComboBox");
        ScrollPane mainScrollPane = (ScrollPane) scene.lookup("#mainScrollPane");

        mainScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        //liceComboBox.setItems(FXCollections.observableArrayList("Eufránio Diogo", "Creuma Diogo"));
    }
}
