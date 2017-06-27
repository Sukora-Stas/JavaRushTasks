package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scn1 = new Scanner(System.in);
        int age = scn1.nextInt();
        Scanner scn2 = new Scanner(System.in);
        String name = scn2.nextLine();
        System.out.println(name + " захватит мир через "+age+" лет. Му-ха-ха!");
    }
}
