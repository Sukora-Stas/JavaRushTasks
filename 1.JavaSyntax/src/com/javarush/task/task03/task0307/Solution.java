package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        Zerg zerg1 = new Zerg();
//        zerg1.name = "1";
//        Zerg zerg2 = new Zerg();
//        zerg2.name = "2";
//        Zerg zerg3 = new Zerg();
//        zerg3.name = "3";
//        Zerg zerg4 = new Zerg();
//        zerg4.name = "4";
//        Zerg zerg5 = new Zerg();
//        zerg5.name = "5";
//        Zerg zerg6 = new Zerg();
//        zerg6.name = "6";
//        Zerg zerg7 = new Zerg();
//        zerg7.name = "7";
//        Zerg zerg8 = new Zerg();
//        zerg8.name = "8";
//        Zerg zerg9 = new Zerg();
//        zerg9.name = "9";
//        Zerg zerg10 = new Zerg();
//        zerg10.name = "10";

        for (int i = 0; i < 10; i++) {
            Zerg zerg = new Zerg();
            zerg.name = "zerg" + i;
        }
        for (int i = 0; i < 5; i++) {
            Protoss protoss = new Protoss();
            protoss.name = "prot" + i;
        }
        for (int i = 0; i < 12; i++) {
            Terran terran = new Terran();
            terran.name = "ter" + i;
        }

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
