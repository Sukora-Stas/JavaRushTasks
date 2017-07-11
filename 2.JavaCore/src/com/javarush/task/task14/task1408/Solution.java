package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory implements Country {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if (country.equals(BELARUS)) {
                hen = new BelarusianHen();
//                System.out.println(hen.getDescription());
            } else if (country.equals(UKRAINE)) {
                hen = new UkrainianHen();
            } else if (country.equals(RUSSIA)) {
                hen = new RussianHen();
            } else if (country.equals(MOLDOVA)) {
                hen = new MoldovanHen();
            }
            return hen;
        }
    }


}
