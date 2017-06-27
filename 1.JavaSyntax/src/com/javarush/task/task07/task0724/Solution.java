package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human granFather1 = new Human("Petya", true, 80);
        Human granFather2 = new Human("Wowa", true, 84);

        Human granMother1 = new Human("Katya", false, 60);
        Human granMother2 = new Human("Alyana", false, 70);

        Human father = new Human("Igor", true, 40, granFather1, granMother1);
        Human mother = new Human("Irina", false, 38, granFather2, granMother2);

        Human son1 = new Human("Stas", true, 20, father, mother);
        Human son2 = new Human("Kostya", true, 27, father, mother);
        Human dauther = new Human("Alyana", false, 21, father, mother);

        System.out.println(granFather1);
        System.out.println(granFather2);

        System.out.println(granMother1);
        System.out.println(granMother2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(son1);
        System.out.println(son2);
        System.out.println(dauther);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















