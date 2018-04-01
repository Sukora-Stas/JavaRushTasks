package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        PhotoPaint photoPaint = new PhotoPaint();

        Color[][] image = {{Color.YELLOW, Color.YELLOW, Color.YELLOW}, {Color.YELLOW, Color.YELLOW, Color.YELLOW}, {Color.YELLOW, Color.YELLOW, Color.YELLOW}};

        System.out.println("Before");
        //Show
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        photoPaint.paintFill(image, 1, 1, Color.RED);
        System.out.println("After");
        //Show
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }

    }
}
