package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static void main(String[] args) throws Exception {
        Person person = null;
        if(args[0].equals("-c"))
        {
            if(args[2].equals("м"))
            {
                allPeople.add(Person.createMale(args[1],new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
            }
            else if(args[2].equals("ж"))
            {
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
            }
            System.out.println(allPeople.size()-1);
        }
        else if(args[0].equals("-u"))
        {
            person =  allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));
            if(args[2].equals("м"))
            {
                person.setSex(Sex.MALE);
            }
            else if(args[2].equals("ж"))
            {
                person.setSex(Sex.FEMALE);
            }
            allPeople.set(Integer.parseInt(args[1]), person);
        }
        else if(args[0].equals("-d"))
        {   person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setBirthDay(null);
            person.setSex(null);
            allPeople.set(Integer.parseInt(args[1]),person);
        }
        else if(args[0].equals("-i"))
        {
            person = allPeople.get(Integer.parseInt(args[1]));
            String sex = "";
            if(person.getSex().equals(Sex.FEMALE))
            {
                sex = "ж";
            }else if(person.getSex().equals(Sex.MALE))
            {
                sex = "м";
            }
            SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
            String date = simpleDateFormat.format(person.getBirthDay());
            System.out.println(person.getName() + " " + sex + " " + date);
        }

    }
}
