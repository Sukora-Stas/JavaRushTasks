package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String url = bufferedReader.readLine();
        String [] urlParamsTemp = url.split("\\?");
        String [] urlParams = urlParamsTemp[1].split("\\&");
        String[] ahtung = null;
        for (String s: urlParams) {
            String[] strTemp = s.split("=");
            if ("obj".equals(strTemp[0]))
                ahtung = strTemp;
            System.out.print(strTemp[0] + " ");

        }
        System.out.println();
        if (ahtung != null)
            try {
                alert(Double.parseDouble(ahtung[1]));
            }
            catch (NumberFormatException e){
                alert(ahtung[1]);
            }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
