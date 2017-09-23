package com.javarush.task.task29.task2901;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Рефакторинг в соответствии с Naming and Code Convention
*/
public class Solution {
    public static final String DEFAULT_FILE_NAME = "C:/tmp/file_strange_name.tmp";

    private final String localFileName;
    private List<String> contentAsLines;
    private boolean fileLoaded;

    public Solution(String firstFileName) {
        localFileName = firstFileName == null ? DEFAULT_FILE_NAME : firstFileName;
    }

    public boolean isFileLoaded() {
        return fileLoaded;
    }

    public void downloadFileContent() {
        Path source = Paths.get(localFileName);

        try {
            contentAsLines = Files.readAllLines(source, Charset.defaultCharset());
            fileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean hasFileExpectedLine(String expectedLine) {
        return contentAsLines.contains(expectedLine);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String packageName = Solution.class.getPackage().getName().replaceAll("[.]", "\\\\");
        String fileName = "src\\" + packageName + "\\Solution.java";

        Solution solution = new Solution(fileName);
        solution.downloadFileContent();
        if (solution.isFileLoaded()) {
            System.out.println(solution.hasFileExpectedLine("public class Solution {"));   //expected true
            System.out.println(solution.hasFileExpectedLine(" public class Solution {"));  //expected false
        }
    }
}
