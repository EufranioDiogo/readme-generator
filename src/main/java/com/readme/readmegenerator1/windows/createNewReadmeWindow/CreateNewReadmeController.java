package com.readme.readmegenerator1.windows.createNewReadmeWindow;

import com.readme.logic.services.readme.ReadmeParam;
import com.readme.logic.services.readme.ReadmeReader;
import com.readme.readmegenerator1.MainApplication;
import com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow.SelectDestinationDirectoryWindowApplication;
import com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow.SelectDestinationDirectoryWindowController;
import com.readme.readmegenerator1.windows.selectTemplateWindow.SelectTemplateWindowApplication;
import com.readme.readmegenerator1.windows.utils.CloseAndOpen;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

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
    public static Path readmeSelected;
    public AnchorPane formAnchorPane;
    public List<Node> listOfNodeParams;
    public int layoutY = 0;


    public void goToMainWindow() {
        try {
            new SelectTemplateWindowApplication().start(new Stage());
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

    @FXML
    public void initialize() {
        System.out.println("Create components");
        NavigableSet<ReadmeParam> readmeParams = ReadmeReader.extractReadmeParam(readmeSelected);

        System.out.println(readmeSelected);
        readmeParams.stream().forEach(System.out::println);

        buildFormByReadmeParams(readmeParams);
    }


    private void buildFormByReadmeParams(NavigableSet<ReadmeParam> readmeParams) {
        int layoutY = 0;
        listOfNodeParams = new ArrayList<>();


        listOfNodeParams.addAll(
                readmeParams
                        .stream()
                        .map(readmeParam -> {
                            Node node = readmeParam.generateNode();

                            node = putLayoutToNodeOnPane(node, readmeParam.getParamType());

                            return node;
                        })
                        .collect(Collectors.toList())
        );

        formAnchorPane
                .getChildren()
                .addAll(listOfNodeParams);
    }

    private Node putLayoutToNodeOnPane(Node node, String paramType) {
        node.setLayoutX(21);

        node.setLayoutY(getMarginSpace(paramType));

        return node;
    }

    private int getMarginSpace(String paramType) {
        int nodeYPosition = layoutY;

        switch (paramType) {
            case "text_field":
                layoutY += 60;
                break;
            case "text_area_field":
                layoutY += 220;
                break;
            default:
                break;
        }
        return nodeYPosition;
    }
}
