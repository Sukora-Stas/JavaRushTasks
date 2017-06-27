package com.javarush.task.task04.task0407;

/* 
Кошки во Вселенной
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        //напишите тут ваш код
        cat1.count++;

        Cat cat2 = new Cat();
        //напишите тут ваш код
        cat2.count++;

        System.out.println("Cats count is " + Cat.count);
    }

    public static class Cat {
        public static int count = 0;

    }
}