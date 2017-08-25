package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/*
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        while (reader.ready()) {
            sb.append(reader.readLine());
            sb.append(" ");
        }

        String[] items = sb.toString().split("\\s");

        for(String item : items){
            for(String item1 : items){
                StringBuilder sb1 = new StringBuilder(item1);
                if(item.equals(sb1.reverse().toString())){
                    Pair pair = new Pair(item, item1);
                    Pair pair1 = new Pair(item1, item);
                    if(!result.contains(pair) && !result.contains(pair1) && item != item1)
                        result.add(pair);
                }
            }
        }

        for(Pair item : result) {
            System.out.println(item.toString());
        }


    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
