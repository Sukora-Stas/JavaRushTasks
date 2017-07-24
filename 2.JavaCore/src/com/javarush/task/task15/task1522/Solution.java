package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }


    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = reader.readLine();
            if (s.equals(Planet.EARTH)) {
                thePlanet = Earth.getInstance();
            } else if (s.equals(Planet.MOON)) {
                thePlanet = Moon.getInstance();

            } else if (s.equals(Planet.SUN)) {
                thePlanet = Sun.getInstance();
            } else {
                thePlanet = null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
