package com.readme.logic.interfaces.helpers.files;

import java.io.IOException;
import java.nio.file.Path;

public interface FileReaderInterface {

    void loadFile(Path file) throws IOException;

    void closeFile();
    String readLine() throws IOException;

}
