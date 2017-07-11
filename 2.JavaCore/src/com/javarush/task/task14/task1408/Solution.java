package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            return hen;
        }
    }

    abstract class Hen {
        public abstract int getCountOfEggsPerMonth();

        String getDescription() {
            return "Я - курица";
        }
    }

    class RussianHen extends Hen{

        @Override
        public int getCountOfEggsPerMonth() {
            return 0;
        }
    }

    class Ukrainian extends Hen

}
