package com.readme.readmegenerator1.windows.utils;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class CloseAndOpen {
    public static <T extends Pane> void close(T window) {
        Stage stage = (Stage) window.getScene().getWindow();

        stage.close();
    }
}
