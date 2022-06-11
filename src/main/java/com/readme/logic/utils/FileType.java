package com.readme.logic.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum FileType {

    NORMAL(1){
        @Override
        public Path getTemplatePath() {
            return Paths.get(Constants.TEMPLATE_RESOURCES_PATH_README);
        }
        @Override
        public String toString() {
            return "NORMAL";
        }

    },
    README(2) {
        @Override
        public Path getTemplatePath() {
            return Paths.get(Constants.TEMPLATE_RESOURCES_PATH_README);
        }
        @Override
        public String toString() {
            return "README";
        }
    };
    int type;

    FileType(int type) {}
    public abstract Path getTemplatePath();

    public int getType() {
        return type;
    }

    public String getOutputTemplatePath() {
        return Constants.TEMPLATE_RESOURCES_PATH_OUTPUT;
    }
}
