package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        try {
//            String fileName = reader.readLine();
//
//            InputStream inputStream = new FileInputStream(fileName);
//
//            ArrayList<Character> list = new ArrayList<>();
//            Collections.sort(list);
//
//            while (inputStream.available() > 0) {
//                int a = Character.valueOf((char) inputStream.read());
//                if (a % 2 == 0 && a!=0)
//                    System.out.println((char)a);
//            }
//
//
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
try{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Scanner freader = new Scanner(new FileInputStream(reader.readLine()));
    ArrayList<Integer> arrayList = new ArrayList<>();

    while ( freader.hasNext() ){
        int i = Integer.parseInt( freader.next() );
        if ( i%2 == 0) arrayList.add(i);
    }

    Collections.sort(arrayList);
    for (Integer i : arrayList){
        System.out.println(i + " ");
    }

    freader.close(); reader.close();
} catch(Exception e){

}


    }
}
