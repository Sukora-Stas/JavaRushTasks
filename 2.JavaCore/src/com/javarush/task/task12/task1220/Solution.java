package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы Run, Swim
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and public class here - добавь public интерфейсы и public класс тут
    public abstract class Human implements Run, Swim {

    }

    public interface Run {
        void Run();
    }

    public interface Swim {
        void Swim();
    }


}
