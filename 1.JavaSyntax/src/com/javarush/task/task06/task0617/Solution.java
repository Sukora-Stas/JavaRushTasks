package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    public static void printIdea(Idea idea) {
        System.out.println(idea.getDescription());
    }

    //напишите тут ваш код
    public static class Idea {
        public String getDescription() {
            return "some text";
        }
    }
}
