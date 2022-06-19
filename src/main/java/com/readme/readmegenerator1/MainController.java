package com.readme.readmegenerator1;

import com.readme.readmegenerator1.windows.createNewReadmeWindow.CreateNewReadmeApplication;
import com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow.SelectDestinationDirectoryWindowApplication;
import com.readme.readmegenerator1.windows.selectTemplateWindow.SelectTemplateWindowApplication;
import com.readme.readmegenerator1.windows.utils.CloseAndOpen;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
    @FXML
    public VBox mainWindow;
    @FXML
    private MenuItem newReadme;

    @FXML
    protected void openCreateNewReadmeWindow() {
        try {
            new SelectTemplateWindowApplication().start(new Stage());
            CloseAndOpen.close(mainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
