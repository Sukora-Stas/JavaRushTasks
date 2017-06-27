package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 1; i<11; i++){
            int[] massive = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            for (int j = 1; j<11; j++){
                int l = j * massive[i];
                System.out.print(l + " ");
            }
            System.out.println("");
        }
    }
}
