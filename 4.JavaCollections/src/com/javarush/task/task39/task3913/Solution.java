package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));

        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getUniqueIPs(null, new Date()));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, null));
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getUsersForIP("192.168.100.2", null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getDownloadedPluginUsers(null, null));
        System.out.println(logParser.getWroteMessageUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null, 18));
        System.out.println(logParser.getDoneTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null, 15));
        System.out.println("task 3:");
        System.out.println(logParser.getDatesForUserAndEvent("Amigo", Event.DONE_TASK, null, null));
        System.out.println(logParser.getDatesWhenSomethingFailed(null, null));
        System.out.println(logParser.getDatesWhenErrorHappened(null, null));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", null, null));
        System.out.println(logParser.getDateWhenUserSolvedTask("Vasya Pupkin", 18, null, null));
        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, null));
        System.out.println(logParser.getDatesWhenUserWroteMessage("Vasya Pupkin", null, null));
        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko", null, null));
        System.out.println("task 4:");
        System.out.println(logParser.getNumberOfAllEvents(null, null));
        System.out.println(logParser.getAllEvents(null, null));
        System.out.println(logParser.getEventsForIP("192.168.100.2", null, null));
        System.out.println(logParser.getEventsForUser("Vasya Pupkin", null, null));
        System.out.println(logParser.getFailedEvents(null, null));
        System.out.println(logParser.getErrorEvents(null, null));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println("task 5:");
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));
        System.out.println("task 6:");
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between\n" +
                "\"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}