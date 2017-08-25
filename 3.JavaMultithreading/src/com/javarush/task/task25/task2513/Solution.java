//package com.javarush.task.task25.task2513;
//
//import java.util.Random;
//
///*
//Обеспечение отсутствия прерывания важной операции
//*/
//public class Solution {
//    private static final Integer THRESHOLD_VALUE = 500;
//    private static final Random RANDOM = new Random();
//
//    public synchronized void moveMoney(Account from, Account to, int amount) throws InterruptedException {
//        from.setBalance(from.getBalance() - amount);
//        if (RANDOM.nextInt(5000) > THRESHOLD_VALUE)
//            Thread.yield();
//        to.setBalance(to.getBalance() + amount);
//    }
//
//
//    private class Account {
//        private int balance;
//
//        public int getBalance() {
//            return balance;
//        }
//
//        public void setBalance(int balance) {
//            this.balance = balance;
//        }
//    }
//
//}
package com.javarush.task.task25.task2513;

import java.util.Random;

/*
Просмотри метод moveMoney.
Если RANDOM.nextInt(5000) больше порогового значения THRESHOLD_VALUE, то обеспечь переуступку кванта времени (переход хода для текущей нити).
Добавь этот код в единственное допустимое место.
*/
public class Solution {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {



        from.setBalance(from.getBalance() - amount);
        if(RANDOM.nextInt(5000) > THRESHOLD_VALUE) {
            Thread.yield();
        }
        to.setBalance(to.getBalance() + amount);
    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
    }
}
