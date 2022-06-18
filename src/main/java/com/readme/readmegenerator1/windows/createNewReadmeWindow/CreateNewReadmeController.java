package com.readme.readmegenerator1.windows.createNewReadmeWindow;

import com.readme.readmegenerator1.MainApplication;
import com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow.SelectDestinationDirectoryWindowApplication;
import com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow.SelectDestinationDirectoryWindowController;
import com.readme.readmegenerator1.windows.utils.CloseAndOpen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    public void goToMainWindow() {
        try {
            new MainApplication().start(new Stage());
            CloseAndOpen.close(mainWindow);
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

        SelectDestinationDirectoryWindowController.readmeParamValueHashMap = paramsAndValues;

        cleanInputFields();



        try {
            new SelectDestinationDirectoryWindowApplication().start(new Stage());
            CloseAndOpen.close(mainWindow);
            /*creationMessage
                    .setText(ResourceBundle.getBundle("labels", Locale.getDefault())
                    .getString("README_CREATION_SUCCESS"));*/
        } catch (IOException e) {
            e.printStackTrace();
           /* creationMessage
                    .setText(ResourceBundle.getBundle("labels", Locale.getDefault())
                    .getString("README_CREATION_ERROR"));*/
        } catch (Exception e) {
            e.printStackTrace();
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
