package com.readme.logic.services.readme;

import com.readme.readmegenerator1.fields.ReadmeParamNode;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReadmeParam implements Comparable<ReadmeParam> {
    protected int line;
    protected final String paramName;
    protected final String paramType;
    protected final String paramLabel;
    protected String paramValue;

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

    public ReadmeParamNode getReadmeParamNode() {
        return new ReadmeParamNode(this);
    }
}
