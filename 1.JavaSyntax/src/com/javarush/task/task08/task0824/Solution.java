package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Human> childlist1 = new ArrayList<>();
        ArrayList<Human> childlist2 = new ArrayList<>();
        ArrayList<Human> childlist3 = new ArrayList<>();


        Human ded1 = new Human("Саша", true, 65,childlist1);
        Human ded2 = new Human("Алексей", true, 65,childlist2);

        Human oldwoman1 = new Human("Даша", false,55,childlist1);
        Human oldwoman2 = new Human("Нюша", false,55,childlist2);

        Human dad = new Human("Юра", true,45,childlist3);
        Human mam = new Human("Аня", false, 40,childlist3);

        Human chil1 = new Human("Юра",true, 10,null);
        Human chil2 = new Human("Аня",false,11,null);
        Human chil3 = new Human("Вика",false,13,null);

        childlist1.add(dad);
        childlist2.add(mam);
        childlist3.add(chil1);
        childlist3.add(chil2);
        childlist3.add(chil3);


        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(oldwoman1);
        System.out.println(oldwoman2);
        System.out.println(dad);
        System.out.println(mam);
        System.out.println(chil1);
        System.out.println(chil2);
        System.out.println(chil3);





    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;


        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.children != null) {
                int childCount = this.children.size();
                if (childCount > 0) {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++) {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }
            return text;
        }
    }

}