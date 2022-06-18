package com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow;

import com.readme.logic.TemplateGenerator;
import com.readme.logic.utils.FileType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class SelectDestinationDirectoryWindowController {
    public static Map<String, String> readmeParamValueHashMap;
    @FXML
    public Button goBack;
    @FXML
    public Button createNewReadmeButton;
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
                                SelectDestinationDirectoryWindowController.readmeParamValueHashMap
                        );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
