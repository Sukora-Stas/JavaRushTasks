package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) createPerson(args[i], args[i + 1], args[i + 2]);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4)
                        updatePerson(Integer.parseInt(args[i]), args[i + 1], args[i + 2], args[i + 3]);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) showPerson(Integer.parseInt(args[i]));
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) deletePerson(Integer.parseInt(args[i]));
                }
                break;
        }
    }

    public static void createPerson(String name, String sex, String birthday) throws ParseException {
        if (sex.equals("ж"))
            allPeople.add(Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday)));
        else if (sex.equals("м"))
            allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday)));
        System.out.println(allPeople.size() - 1);
    }

    public static void updatePerson(int id, String name, String sex, String birthday) throws ParseException {
        allPeople.get(id).setName(name);
        allPeople.get(id).setSex(sex.equals("ж") ? Sex.FEMALE : Sex.MALE);
        allPeople.get(id).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday));
    }

    public static void showPerson(int id) {
        SimpleDateFormat date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = allPeople.get(id);
        System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + date.format(person.getBirthDay()));
    }

    public static void deletePerson(int id) {
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }
}

