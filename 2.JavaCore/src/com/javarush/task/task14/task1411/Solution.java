package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;


        while (true) {
            key = reader.readLine();
            if (!((key.equals("user")) || (key.equals("loser")) || (key.equals("coder")) || (key.equals("proger"))))
                break;
            else if (key.equals("user")) person = new Person.User();
            else if (key.equals("loser")) person = new Person.Loser();
            else if (key.equals("coder")) person = new Person.Coder();
            else if (key.equals("proger")) person = new Person.Proger();
            doWork(person); //вызываем doWork
        }
    }
//    public static void doWork(Person person) {
//        if (person instanceof Person.User) ((Person.User) person).live();
//        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
//        else if (person instanceof Person.Coder) ((Person.Coder) person).coding();
//        else if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
//    }
//

//        String sArr[] = {"user", "loser", "coder", "proger"};
//
//        ArrayList<String> list = new ArrayList<>();
//
//        //!(s = reader.readLine()).equals(sArr)
//        while (true) {
//           String s = reader.readLine();
//                if (!s.equals("user") || !s.equals("loser") || !s.equals("coder") || !s.equals("proger")) {
//                    break;
//                }
//
//            list.add(s);
//
//        }
//
////        for (String str : list) {
////            if (str.equals("user")) {
////                Person.User user = new Person.User();
////                doWork(user);
////            } else if (str.equals("loser")) {
////                Person.Loser loser = new Person.Loser();
////                doWork(loser);
////            } else if (str.equals("coder")) {
////                Person.Coder coder = new Person.Coder();
////                doWork(coder);
////            } else if (str.equals("proger")) {
////                Person.Proger proger = new Person.Proger();
////                doWork(proger);
////            }
////
////        }


    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
