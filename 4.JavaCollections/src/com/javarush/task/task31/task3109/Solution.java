package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        int pos = fileName.lastIndexOf(".");
        String ext = pos >= 0 ? fileName.substring(pos) : "";

        try {
            switch (ext) {
                case ".xml": {
                    FileInputStream fileInputStream = new FileInputStream(fileName);
                    properties.loadFromXML(fileInputStream);
                    fileInputStream.close();
                    break;
                }
                case ".txt": {
                    FileReader fileReader = new FileReader(fileName);
                    properties.load(fileReader);
                    fileReader.close();
                    break;
                }
                default: {
                    FileInputStream fileInputStream = new FileInputStream(fileName);
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return properties;
        }

        return properties;
    }
}
