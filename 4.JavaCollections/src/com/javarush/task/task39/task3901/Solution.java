package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        ArrayList<Integer> lenghtList = new ArrayList<>();


        for (int ii = 0; ii < s.length(); ii++) {
            String sss = s.substring(ii, s.length());

            StringBuffer noRepeatLattersString = new StringBuffer();
            noRepeatLattersString.append(sss.charAt(0));
            exit:
            for (int i = 1; i < sss.length(); i++) {
                for (int j = 0; j < noRepeatLattersString.length(); j++)
                    if (noRepeatLattersString.charAt(j) == sss.charAt(i))
                        break exit;

                noRepeatLattersString.append(sss.charAt(i));
            }
            lenghtList.add(noRepeatLattersString.toString().length());
        }

        return Collections.max(lenghtList);
    }
}
