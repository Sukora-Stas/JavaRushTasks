package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try {
            //            String data = args[0].toUpperCase();
            //            char[] chars =data.toCharArray();
            //            int base = 48;
            //            int count = 0;
            //            boolean flag = false;
            //            for (int k = 2; k <= 36; k++) {
            //                if (k <= 10) {
            //                    base++;
            //                }
            //                if (k > 10) {
            //                    base = 65 + count++;
            //                }
            //                for (int i = 0; i < chars.length; i++) {
            //                    if (chars[i] < 48 || chars[i] > 90) {
            //                        throw new IllegalArgumentException();
            //                    }
            //                    if (chars[i] >= 48 && chars[i] <= base) {
            //                        flag = true;
            //                    } else {
            //                        flag = false;
            //                        break;
            //                    }
            //                }
            //                if (flag) {
            //                    System.out.println(k);
            //                    break;
            //                }
            //            }
            BigDecimal num;
            boolean flag = false;
            for (int i = 2; i < 37; i++) {
                try {
                    num = new BigDecimal(new BigInteger(args[0], i));
                    flag = true;
                    if(flag){
                        System.out.println(i);
                        break;
                    }
                } catch (Exception e) {
//                        System.out.println("incorrect");
                }
            }
            if (!flag) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
//                e.printStackTrace();
            System.out.println("incorrect");
        }
    }
}