package com.readme.readmegenerator1.windows.utils;

import javafx.application.Application;
import javafx.scene.layout.VBox;

public interface CloseAndOpen {
    default <T extends Application, R extends VBox> void close(T window, R element) {
    };
}
