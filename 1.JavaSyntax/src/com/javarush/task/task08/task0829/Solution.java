package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //list of addresses
        HashMap<String,String> map = new HashMap<>();
        while(true) {
            String s1 = reader.readLine();
            if(s1.isEmpty()){
                break;
            }else{
                String s2 = reader.readLine();
                map.put(s1,s2);
            }
        }
        String ss = reader.readLine();
        if(map.containsKey(ss)){
            System.out.println(map.get(ss));
        }

//        HashMap<String,String> map=new HashMap<>();
//
//        map.put("Ивановы","Москва");
//        map.put("Петровы","Киев");
//        map.put("Абрамовичи","Лондон");
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = reader.readLine();
//
//        for (Map.Entry<String, String> city :map.entrySet()) {
//            if (s.equals(city.getValue())){
//                System.out.println(city.getKey());
//            }
//        }

    }
}
