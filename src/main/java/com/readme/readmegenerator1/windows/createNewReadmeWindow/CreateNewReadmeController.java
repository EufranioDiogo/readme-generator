package com.readme.readmegenerator1.windows.createNewReadmeWindow;

import com.readme.logic.TemplateGenerator;
import com.readme.logic.services.readme.ReadmeParam;
import com.readme.logic.services.readme.ReadmeReader;
import com.readme.logic.utils.FileType;
import com.readme.readmegenerator1.MainApplication;
import com.readme.readmegenerator1.fields.ReadmeParamNode;
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
    public List<ReadmeParamNode> listOfNodeParams;
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

        listOfNodeParams.forEach(readmeParamNode -> {
            paramsAndValues.put(readmeParamNode.getReadmeParam().getParamName(), readmeParamNode.getSpecific().getText());
        });

        SelectDestinationDirectoryWindowController.readmeParamValueHashMap = paramsAndValues;
        SelectDestinationDirectoryWindowController.readmeSelectedPath = readmeSelected;

        try {
            new SelectDestinationDirectoryWindowApplication().start(new Stage());
            CloseAndOpen.close(mainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cleanInputFields();




    }


    private void cleanInputFields() {
        listOfNodeParams.forEach(readmeParamNode -> {
            readmeParamNode.getSpecific().setText("");
        });
    }

    @FXML
    public void initialize() {
        System.out.println("Create components");
        LinkedHashSet<ReadmeParam> readmeParams = ReadmeReader.extractReadmeParam(readmeSelected);

        System.out.println(readmeSelected);
        readmeParams.stream().forEach(System.out::println);

        buildFormByReadmeParams(readmeParams);
    }


    private void buildFormByReadmeParams(LinkedHashSet<ReadmeParam> readmeParams) {
        listOfNodeParams = new ArrayList<>();


        listOfNodeParams.addAll(
                readmeParams
                        .stream()
                        .map(readmeParam -> readmeParam.getReadmeParamNode())
                        .collect(Collectors.toList())
        );

        formAnchorPane
                .getChildren()
                .addAll(listOfNodeParams.stream().map(readmeParamNode -> {
                    Node node = readmeParamNode.generateRepresentativeNode();

                    node = putLayoutToNodeOnPane(node, readmeParamNode.getReadmeParam().getParamType());

                    return node;
                }).collect(Collectors.toList()));

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
                layoutY += 210;
                break;
            default:
                break;
        }
        return nodeYPosition;
    }
}
