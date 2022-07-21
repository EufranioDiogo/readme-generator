package com.readme.readmegenerator1.fields;

import com.readme.logic.services.readme.ReadmeParam;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

public class ReadmeParamNode extends Node {
    private final ReadmeParam readmeParam;
    private Node node;

    public ReadmeParamNode(ReadmeParam readmeParam) {
        super();
        this.readmeParam = readmeParam;
    }

    public Node generateRepresentativeNode() {
        if (this.node != null) {
            return this.node;
        }

        switch (this.readmeParam.getParamType()) {
            case "text_field":
                TextField textField = new TextField();
                textField.setPromptText(this.readmeParam.getParamLabel());
                textField.setId(this.readmeParam.getParamName());
                textField.getStyleClass().add("text-field");


                this.node = textField;

                return this.node;
            case "text_area_field":
                TextArea textArea = new TextArea();
                textArea.setPromptText(this.readmeParam.getParamLabel());
                textArea.setId(this.readmeParam.getParamName());
                textArea.getStyleClass().add("text-area");

                this.node = textArea;
                return this.node;
            default:
                return null;
        }
    }

    public ReadmeParam getReadmeParam() {
        return readmeParam;
    }

    public Node getNode() {
        return node;
    }

    public TextInputControl getSpecific() {
        switch (this.readmeParam.getParamType()) {
            case "text_field":
                return (TextField) this.node;
            case "text_area_field":
                return (TextArea) this.node;
            default:
                return null;
        }
    }
}
