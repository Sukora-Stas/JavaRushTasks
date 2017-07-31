package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            allLines = (Files.readAllLines(Paths.get(file1)));
            forRemoveLines = (Files.readAllLines(Paths.get(file2)));
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public synchronized void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            for (int i = allLines.size() - 1; i >= 0; i--) {
                allLines.remove(i);
            }
            throw new CorruptedDataException();
        }

    }
}
