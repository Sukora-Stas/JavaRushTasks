package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("Orange,Green,Yellow,Red",",");

        for (String s : strings)
            System.out.println(s);
    }

    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] result = new String[st.countTokens()];

        for (int i=0; st.hasMoreElements();i++) {
            result[i] = st.nextToken();
        }

        return result;
    }
}
