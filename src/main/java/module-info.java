module com.readme.readmegenerator1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires dotenv.java;
    requires org.json;

    opens com.readme.readmegenerator1 to javafx.fxml;
    opens com.readme.readmegenerator1.windows.createNewReadmeWindow to javafx.fxml;
    opens com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow to javafx.fxml;
    opens com.readme.readmegenerator1.windows.selectTemplateWindow to javafx.fxml;
    exports com.readme.readmegenerator1;
    exports com.readme.readmegenerator1.windows.createNewReadmeWindow;
    exports com.readme.readmegenerator1.windows.selectDestinationDirectoryWindow;
    exports com.readme.readmegenerator1.windows.selectTemplateWindow;
}
