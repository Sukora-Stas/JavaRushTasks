package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grendFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grendFatherName);

        String grendMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grendMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);

        String sonName = reader.readLine();
        Cat carSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);

        System.out.println(catFather);
        System.out.println(catMother);

        System.out.println(carSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

//        Cat(String name, Cat parent){
//            this.name=name;
//            this.father=father;
//        }

        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother" + ", no father";
            else if (mother != null && father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else if (mother == null && father != null)
                return "Cat name is " + name + ", no mother " + ", father is " + father.name;
            else return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}
