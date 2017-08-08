package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while (!"exit".equals(input = reader.readLine())) {
            new ReadThread(input).start();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream file = new FileInputStream(fileName);
                TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                while (file.available() > 0) {
                    int data = file.read();
                    if (!map.containsKey(data)) {
                        map.put(data, 1);
                    } else {
                        map.put(data, map.get(data) + 1);
                    }
                }
                file.close();
                int maxCount = 0;
                int maxMetByte = 0;
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (maxCount < pair.getValue()) {
                        maxCount = pair.getValue();
                        maxMetByte = pair.getKey();
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, maxMetByte);
                }
            } catch (IOException e) {
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
