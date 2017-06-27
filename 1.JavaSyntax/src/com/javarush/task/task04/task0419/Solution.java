package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

//public class Solution {
//    public static void main(String[] args) throws Exception {
//        //напишите тут ваш код
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String name = reader.readLine();
//        String sAge = reader.readLine();
//        int nAge = Integer.parseInt(sAge);
//
//        Scanner scanner = new Scanner(System.in);
//        int n1 = scanner.nextInt();
//        int n2 = scanner.nextInt();
//        int n3 = scanner.nextInt();
//        int n4 = scanner.nextInt();
//
//        if (n1 == n2 && n2 == n3 && n3 == n4) {
//            System.out.println(n3);
//        } else if (n1 > n2 && n1 > n3 && n1 > n4) {
//            System.out.println(n1);
//        } else if (n2 > n3 && n2 > n1 && n2 > n4) {
//            System.out.println(n2);
//        } else if (n3 > n4 && n3 > n1 && n3 > n2) {
//            System.out.println(n3);
//        } else if (n4 > n1 && n4 > n2 && n4 > n3) {
//            System.out.println(n4);
//        }
//
//
//    }
//}

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        if (max(a, b) > max(c, d)) {
            System.out.println(max(a, b));
        } else {
            System.out.println(max(c, d));
        }
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
}
