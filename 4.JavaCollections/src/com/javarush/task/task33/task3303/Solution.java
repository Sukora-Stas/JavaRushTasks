package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        T result = null;
        ObjectMapper mapper = new ObjectMapper();
        StringReader reader;

//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//            StringBuffer sb = new StringBuffer("");
//            while (fileReader.ready())
//                sb.append(fileReader.readLine());
//
//            reader = new StringReader(sb.toString());
//        }

        result = mapper.readValue(new FileReader(new File(fileName)), clazz);
        return result;
    }

    public static void main(String[] args) {

    }
}
