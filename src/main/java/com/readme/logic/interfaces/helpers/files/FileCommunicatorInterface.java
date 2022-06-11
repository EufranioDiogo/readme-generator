package com.readme.logic.interfaces.helpers.files;

import java.io.IOException;
import java.nio.file.Path;

public interface FileCommunicatorInterface {
    boolean copyFromOriginFileTo(Path destFile);
}
