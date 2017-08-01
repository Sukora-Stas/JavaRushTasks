package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = reader.readLine();
//        FileInputStream fileInputStream = new FileInputStream(s);
//        while (fileInputStream.available() < 1000) {
//            s = reader.readLine();
////            fileInputStream = new FileInputStream(s);
////            if (s.isEmpty()) {
////                break;
////            }
//
//            FileInputStream in = new FileInputStream(s);
//            if (in.available() < 1000) {
//                in.close();
//                throw new DownloadException();
//
//            } else {
//                in.close();
//            }
//        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();

        try {
            while (!inFile.isEmpty()) {
                FileInputStream in = new FileInputStream(inFile);
                if (in.available() < 1000) {
                    in.close();
                    throw new DownloadException();

                } else {
                    in.close();
                    inFile = reader.readLine();
                }
            }
        } catch (DownloadException e) {
            throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
