package com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow;

import com.readme.logic.TemplateGenerator;
import com.readme.logic.utils.FileType;
import com.readme.readmegenerator1.MainApplication;
import com.readme.readmegenerator1.windows.createNewReadmeWindow.CreateNewReadmeApplication;
import com.readme.readmegenerator1.windows.utils.CloseAndOpen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class SelectDestinationDirectoryWindowController {
    public static Map<String, String> readmeParamValueHashMap;
    public static Path readmeSelectedPath;
    @FXML
    public Button goBack;
    @FXML
    public Button createNewReadmeButton;
    public VBox mainWindow;
    @FXML
    private TextField directoryLocationTextField;

    public void createReadme() {
        try {
            if (!directoryLocationTextField.getText().isBlank()) {
                TemplateGenerator
                        .generateFile(
                                FileType.README,
                                Paths.get(directoryLocationTextField.getText(),
                                        "README.md"
                                ).toString(),
                                SelectDestinationDirectoryWindowController.readmeParamValueHashMap,
                                readmeSelectedPath
                        );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack(MouseEvent mouseEvent) {
        try {
            new CreateNewReadmeApplication().start(new Stage());
            CloseAndOpen.close(mainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
