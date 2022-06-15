package com.readme.readmegenerator1;

import com.readme.readmegenerator1.windows.createNewReadmeWindow.CreateNewReadmeApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController {
    @FXML
    public VBox mainWindow;
    @FXML
    private MenuItem newReadme;

    @FXML
    protected void openCreateNewReadmeWindow() {
        try {
            new CreateNewReadmeApplication().start(new Stage());
            Stage stage = (Stage) mainWindow.getScene().getWindow();

            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
