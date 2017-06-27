package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    static public ArrayList cats = new ArrayList();

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        Cat cat[] = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cat[i] = new Cat();
            cats.add(cat[i]);
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(Cat.cats.get(i));
        }
    }
}
