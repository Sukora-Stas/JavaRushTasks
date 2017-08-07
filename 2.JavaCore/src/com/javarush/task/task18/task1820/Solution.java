package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String file1 = reader.readLine();
////        String file2 = reader.readLine();
//        reader.close();
//
//        FileInputStream inFile1 = new FileInputStream(file1);
////        FileOutputStream outFile2 = new FileOutputStream(file2);
//
//        ArrayList<Integer> buff = new ArrayList<>();
//
//        while (inFile1.available() > 0) {
//            buff.add((int) (char) inFile1.read());
//        }
//
//        System.out.println(buff);
//
////        for (int i = 0; i < buff.size(); i++) {
////            outFile2.write(buff.get(i));
////        }
//        inFile1.close();
////        outFile2.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedWriter fos = new BufferedWriter(new FileWriter(fileName2));
        BufferedReader bfr = new BufferedReader(new FileReader(fileName1));
        String[] strMas = bfr.readLine().split(" ");
        for (String s : strMas) {
            fos.write(((int) Math.round(Float.parseFloat(s))) + " ");
        }
        fos.close();
        bfr.close();

    }
}
