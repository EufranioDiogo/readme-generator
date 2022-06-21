package com.readme.readmegenerator1.windows.selectTemplateWindow;

import com.readme.logic.services.readme.ReadmeParam;
import com.readme.logic.services.readme.ReadmeReader;
import com.readme.logic.utils.files.ReadmeFileVisitor;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NavigableSet;
import java.util.concurrent.ThreadLocalRandom;

public class SelectTemplateWindowController {
    public VBox mainWindow;
    public AnchorPane templatesContainer;
    public static Path selectedReadme;
    public static Path viewReadme;

    private int templateLayoutX = 14;
    private int templateLayoutY = 14;
    private int numberOfTemplatesAdded = 0;

    public void readReadme(MouseEvent mouseEvent) {
        NavigableSet<ReadmeParam> readmeParams = ReadmeReader.extractReadmeParam(ReadmeFileVisitor.readmeSources.get(0));
    }

    @FXML
    protected void initialize() {
        generateTemplateViewElements();
    }

    /*
    * <AnchorPane layoutX="14.0" layoutY="14.0" prefHeight="287.0" prefWidth="345.0">
           <children>
              <Pane prefHeight="191.0" prefWidth="344.0" style="-fx-border-color: #222; -fx-border-radius: 10px;" />
              <Label layoutX="1.0" layoutY="202.0" prefHeight="22.0" prefWidth="344.0" text="Readme File name">
                 <font>
                    <Font size="16.0" />
                 </font>
              </Label>
              <Button layoutX="6.0" layoutY="246.0" mnemonicParsing="false" text="Selecionar" />
              <Button layoutX="109.0" layoutY="246.0" mnemonicParsing="false" text="Ver" />
           </children>
        </AnchorPane>
    * */
    private void generateTemplateViewElements() {
        Path root = Paths.get("./resources");
        try {
            Files.walkFileTree(root, new ReadmeFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReadmeFileVisitor.readmeSources.forEach(path -> {
            AnchorPane templateAnchorPane = new AnchorPane();
            templateAnchorPane.getStyleClass().add("readme-template-container");
            String background = ThreadLocalRandom.current().nextInt() + "";
            templateAnchorPane.setStyle("-fx-background-color: #" + background.substring(0, 3) + ";");
            Pane photoReadmeContainer = new Pane();

            photoReadmeContainer.getStyleClass().add("readme-template-photo-container");

            Label label = new Label();
            label.getStyleClass().add("readme-template-name");
            label.setText(path.getParent().toString());

            Button selectButton = new Button();
            selectButton.setText("Selecionar");
            selectButton.setOnMouseClicked(event -> SelectTemplateWindowController.selectedReadme = path);

            Button viewButton = new Button();

            viewButton.setOnMouseClicked(event -> SelectTemplateWindowController.viewReadme = path);

            selectButton.setText("Ver");

            templateAnchorPane.getChildren().addAll(photoReadmeContainer, label, selectButton, viewButton);

            templateAnchorPane.setLayoutX(templateLayoutX);
            templateAnchorPane.setLayoutY(templateLayoutY);


            numberOfTemplatesAdded++;

            if (numberOfTemplatesAdded >= 2) {
                // templateLayoutY = templateLayoutY + templateAnchorPaneHeight + space between
                templateLayoutY = templateLayoutY + 287 + 20;
                templateLayoutX = 14;
            } else {
                // templateLayoutX = templateLayoutX + templateAnchorPaneWith + space between
                templateLayoutX = templateLayoutX + 345 + 20;
            }
            templatesContainer.getChildren().add(templateAnchorPane);
        });

        templatesContainer.setPrefHeight(templateLayoutY + 287 + 20);
    }
}
