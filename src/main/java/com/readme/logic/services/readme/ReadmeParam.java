package com.readme.logic.services.readme;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReadmeParam implements Comparable<ReadmeParam> {
    private int line;
    private final String paramName;
    private final String paramType;
    private final String paramLabel;
    private String paramValue;

    public ReadmeParam(String paramDetected) {
        String[] split = paramDetected.split("\\$");

        if (split.length < 3) {
            throw new IllegalArgumentException("The param passed must be devided by 3 parts");
        }

        this.paramName = split[1];
        this.paramType = split[2];
        this.paramLabel = split[3];
    }

    public ReadmeParam(String paramDetected, int line) {
        this(paramDetected);
        this.line = line;
    }

    @Override
    public int compareTo(ReadmeParam o) {
        return this.paramName.compareTo(o.paramName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReadmeParam that = (ReadmeParam) o;

        return this.paramName.equals(that.paramName) && this.paramType.equals(that.paramType);
    }

    @Override
    public int hashCode() {
        int result = paramName.hashCode();
        result = 31 * result + paramType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ReadmeParam{" +
                "line=" + line +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                ", paramLabel='" + paramLabel + '\'' +
                '}';
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getParamName() {
        return paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public String getParamLabel() {
        return paramLabel;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Node generateNode() {
        switch (this.paramType) {
            case "text_field":
                TextField textField = new TextField();
                textField.setPromptText(this.paramLabel);
                textField.setId(this.paramName);
                textField.getStyleClass().add("text-field");

                return textField;
            case "text_area_field":
                TextArea textArea = new TextArea();
                textArea.setPromptText(this.paramLabel);
                textArea.setId(this.paramName);
                textArea.getStyleClass().add("text-area");

                return textArea;
            default:
                System.err.println(this);
                return null;
        }
    }
}
