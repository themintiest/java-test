package com.lumera.wordsearch.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public final class FileUtils {
    private FileUtils() {}

    /**
     * Read file line by line to a collection of strings.
     *
     * @param filePath String resource file path.
     * @return a list of String.
     */
    public static List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error when reading file.");
        }
    }
}
