package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s;
//        while (true) {
//            String s = reader.readLine();
//            if (s.equals("exit")) break;
//
//            if (s.contains(".")) {
//                print(Double.parseDouble(s));
//            } else if (Integer.parseInt(s) < 128 && Integer.parseInt(s) > 0) {
//                print(Short.parseShort(s));
//            } else if (Integer.parseInt(s) >= 128 && Integer.parseInt(s) <= 0) {
//                print(Integer.parseInt(s));
//            } else {
//                print(s);
//            }
//
//
//        }
        while (true) {
            s = r.readLine();
            if (s.equals("exit")) {
                r.close();
                break;
            } else {
                try {
                    if (s.contains(".")) {
                        print(Double.parseDouble(s));
                    } else {
                        Integer i = Integer.parseInt(s);
                        if ((i < 128) && (i > 0)) print(i.shortValue());
                        else
                            print(i);
                    }
                } catch (NumberFormatException e) {
                    print(s);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
