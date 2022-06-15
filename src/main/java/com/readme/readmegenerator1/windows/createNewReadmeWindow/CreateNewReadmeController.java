package com.readme.readmegenerator1.windows.createNewReadmeWindow;

import com.readme.logic.TemplateGenerator;
import com.readme.logic.utils.FileType;
import com.readme.readmegenerator1.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class CreateNewReadmeController {
    @FXML
    public Button goToMainWindowBtn;
    public TextField usernameParamTextField;
    public TextField repoNameParamTextField;
    public TextField domainNameParamTextField;
    public TextField builtWithNameParamTextField;
    public TextArea aboutProjectParamTextField;
    public ComboBox licenseParamComboBox;
    public Button createNewReadmeButton;
    public VBox mainWindow;
    public Label creationMessage;

    public void goToMainWindow() {
        try {
            new MainApplication().start(new Stage());
            Stage stage = (Stage) mainWindow.getScene().getWindow();

            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNewReadme() {
        Map<String, String> paramsAndValues = new HashMap<>();

        paramsAndValues.put("user_name_param", usernameParamTextField.getText());
        paramsAndValues.put("repo_name_param", repoNameParamTextField.getText());
        paramsAndValues.put("domain_name_param", domainNameParamTextField.getText());
        paramsAndValues.put("about_project_param", aboutProjectParamTextField.getText());
        paramsAndValues.put("built_with_param", builtWithNameParamTextField.getText());
        paramsAndValues.put("license_param", licenseParamComboBox.getSelectionModel().toString());
        //paramsAndValues.put("getting_started_param", );
        //paramsAndValues.put("prerequisites_param", );
        //paramsAndValues.put("usage_examples_param", );
        //paramsAndValues.put("tasks_param", );

        cleanInputFields();

        creationMessage.setVisible(true);

        try {
            TemplateGenerator.generateFile(FileType.README, "README.md", paramsAndValues);

            creationMessage
                    .setText(ResourceBundle.getBundle("labels", Locale.getDefault())
                    .getString("README_CREATION_SUCCESS"));
        } catch (IOException e) {
            e.printStackTrace();
            creationMessage
                    .setText(ResourceBundle.getBundle("labels", Locale.getDefault())
                    .getString("README_CREATION_ERROR"));
        }
    }

    private void cleanInputFields() {
        usernameParamTextField.setText("");
        repoNameParamTextField.setText("");
        domainNameParamTextField.setText("");
        aboutProjectParamTextField.setText("");
        builtWithNameParamTextField.setText("");

    }
}
