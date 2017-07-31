package com.javarush.task.task17.task1710;

import com.javarush.task.task17.task1710.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* 
CRUD
*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        String action = args[0];
        switch (action) {
            case "-c":
                create(args[1], args[2], args[3]);
                break;
            case "-u":
                update(args[1], args[2], args[3], args[4]);
                break;
            case "-d":
                delete(args[1]);
                break;
            case "-i":
                show(args[1]);
                break;
            default:
        }
    }
    private static void show(String id) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = allPeople.get(Integer.parseInt(id));
        System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + dateFormat.format(person.getBirthDay()));
    }
    private static void delete(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setBirthDay(null);
        person.setSex(null);
    }
    private static void update(String id, String name, String sex, String bd) throws ParseException {
        Date birth = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bd);
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(name);
        person.setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
        person.setBirthDay(birth);
    }
    private static void create(String name, String sex, String bd) throws ParseException {
        Date birth = new SimpleDateFormat("dd/MM/yyyy").parse(bd);
        allPeople.add("м".equals(sex) ? Person.createMale(name, birth) : Person.createFemale(name, birth));
        System.out.println(allPeople.size() - 1);
    }
}