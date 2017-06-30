package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String lastName;
        private int age;
        private boolean sex;
        private Human mother;
        private Human father;

        public Human(int age, boolean sex, Human mother, Human father) {
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String lastName, int age, Human mother, Human father) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, Human mother, Human father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String lastName, int age, boolean sex, Human mother, Human father) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human(String name, String lastName, int age, boolean sex, Human mother) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
        }

        public Human(String name, String lastName, int age, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String lastName, int age) {

            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String name, String lastName) {

            this.name = name;
            this.lastName = lastName;
        }

        public Human(String name) {

            this.name = name;
        }
    }
}
