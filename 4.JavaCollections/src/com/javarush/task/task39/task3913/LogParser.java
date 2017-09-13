package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery
{

    private Path logDir;
    private List<String> linesList;

    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        linesList = getLinesList();
    }

    private List<String> getLinesList()
    {
        String[] files = logDir.toFile().list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.endsWith(".log");
            }
        });

        List<String> lines = new ArrayList<>();
        for (String file : files)
        {
            try
            {
                lines.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file), Charset.defaultCharset()));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private void addStringEntity(Date after, Date before, Set<String> enteties, String[] parts, int part)
    {
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(parts[part]);
        }
    }

    private void addDateEntity(Date after, Date before, Set<Date> enteties, String[] parts)
    {
        Date lineDate = getDate(parts[2]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(lineDate);
        }
    }

    private void addEventEntity(Date after, Date before, Set<Event> enteties, String[] parts)
    {
        Event lineEvent = Event.valueOf(parts[3].split(" ")[0]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(lineEvent);
        }
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before)
    {
        if (after == null && before == null)
        {
            return true;
        } else if (after == null)
        {
            if (lineDateTime <= before.getTime())
            {
                return true;
            }
        } else if (before == null)
        {
            if (lineDateTime >= after.getTime())
            {
                return true;
            }
        } else
        {
            if (lineDateTime >= after.getTime() && lineDateTime <= before.getTime())
            {
                return true;
            }
        }
        return false;
    }

    private Date getDate(String part)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try
        {
            date = dateFormat.parse(part);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        Set<String> IPsForUser = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1]))
            {
                addStringEntity(after, before, IPsForUser, parts, 0);
            }
        }
        return IPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (event.toString().equals(parts[3].split(" ")[0]))
            {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        Set<String> IPsForEvent = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (status.toString().equals(parts[4]))
            {
                addStringEntity(after, before, IPsForEvent, parts, 0);
            }
        }
        return IPsForEvent;
    }

    @Override
    public Set<String> getAllUsers()
    {
        Set<String> allUsers = new HashSet<>();

        for (String line : linesList)
        {
            allUsers.add(line.split("\\t")[1]);
        }
        return allUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before)
    {
        Set<String> users = new HashSet<>();
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            addStringEntity(after, before, users, parts, 1);
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before)
    {
        Set<String> userEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (user.equals(parts[1]))
            {
                addStringEntity(after, before, userEvents, parts, 2);
            }
        }
        return userEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before)
    {
        Set<String> usersForIP = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (ip.equals(parts[0]))
            {
                addStringEntity(after, before, usersForIP, parts, 1);
            }
        }
        return usersForIP;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before)
    {
        Set<String> loggedUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (Event.LOGIN.toString().equals(parts[3]))
            {
                addStringEntity(after, before, loggedUsers, parts, 1);
            }
        }
        return loggedUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before)
    {
        Set<String> downloadedPluginUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (Event.DOWNLOAD_PLUGIN.toString().equals(parts[3]))
            {
                addStringEntity(after, before, downloadedPluginUsers, parts, 1);
            }
        }
        return downloadedPluginUsers;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before)
    {
        Set<String> wroteMessageUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (Event.WRITE_MESSAGE.toString().equals(parts[3]))
            {
                addStringEntity(after, before, wroteMessageUsers, parts, 1);
            }
        }
        return wroteMessageUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before)
    {
        Set<String> solvedTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0]))
            {
                addStringEntity(after, before, solvedTaskUsers, parts, 1);
            }
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task)
    {
        Set<String> solvedTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                addStringEntity(after, before, solvedTaskUsers, parts, 1);
            }
        }
        return solvedTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before)
    {
        Set<String> doneTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");

            if (Event.DONE_TASK.toString().equals(parts[3].split(" ")[0]))
            {
                addStringEntity(after, before, doneTaskUsers, parts, 1);
            }
        }
        return doneTaskUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task)
    {
        Set<String> doneTaskUsers = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                addStringEntity(after, before, doneTaskUsers, parts, 1);
            }
        }
        return doneTaskUsers;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before)
    {
        Set<Date> datesForUserAndEvent = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]) && event.toString().equals(parts[3].split(" ")[0]))
            {
                addDateEntity(after, before, datesForUserAndEvent, parts);
            }
        }
        return datesForUserAndEvent;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before)
    {
        Set<Date> datesWhenSomethingFailed = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Status.FAILED.toString().equals(parts[4]))
            {
                addDateEntity(after, before, datesWhenSomethingFailed, parts);
            }
        }
        return datesWhenSomethingFailed;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before)
    {
        Set<Date> datesWhenErrorHappened = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Status.ERROR.toString().equals(parts[4]))
            {
                addDateEntity(after, before, datesWhenErrorHappened, parts);
            }
        }
        return datesWhenErrorHappened;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before)
    {
        Date dateWhenUserLoggedFirstTime = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]) && Event.LOGIN.toString().equals(parts[3]))
            {
                if (getDate(parts[2]).getTime() < dateWhenUserLoggedFirstTime.getTime())
                {
                    dateWhenUserLoggedFirstTime = getDate(parts[2]);
                    isDateChanged = true;
                }
            }
        }
        return isDateChanged ? dateWhenUserLoggedFirstTime : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before)
    {
        Date dateWhenUserSolvedTask = new Date(Long.MAX_VALUE);
        boolean isDateChanged = false;
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1])
                    && Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                if (getDate(parts[2]).getTime() < dateWhenUserSolvedTask.getTime())
                {
                    dateWhenUserSolvedTask = getDate(parts[2]);
                    isDateChanged = true;
                }
            }
        }
        return isDateChanged ? dateWhenUserSolvedTask : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before)
    {
        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1])
                    && Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                return getDate(parts[2]);
            }
        }
        return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before)
    {
        Set<Date> datesWhenUserWroteMessage = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]) && Event.WRITE_MESSAGE.toString().equals(parts[3]))
            {
                addDateEntity(after, before, datesWhenUserWroteMessage, parts);
            }
        }
        return datesWhenUserWroteMessage;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before)
    {
        Set<Date> datesWhenUserDownloadedPlugin = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]) && Event.DOWNLOAD_PLUGIN.toString().equals(parts[3]))
            {
                addDateEntity(after, before, datesWhenUserDownloadedPlugin, parts);
            }
        }
        return datesWhenUserDownloadedPlugin;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before)
    {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before)
    {
        Set<Event> eventTypes = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            addEventEntity(after, before, eventTypes, parts);
        }
        return eventTypes;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before)
    {
        Set<Event> EventsForIP = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (ip.equals(parts[0]))
            {
                addEventEntity(after, before, EventsForIP, parts);
            }
        }
        return EventsForIP;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before)
    {
        Set<Event> EventsForUser = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (user.equals(parts[1]))
            {
                addEventEntity(after, before, EventsForUser, parts);
            }
        }
        return EventsForUser;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before)
    {
        Set<Event> FailedEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Status.FAILED.toString().equals(parts[4]))
            {
                addEventEntity(after, before, FailedEvents, parts);
            }
        }
        return FailedEvents;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before)
    {
        Set<Event> ErrorEvents = new HashSet<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Status.ERROR.toString().equals(parts[4]))
            {
                addEventEntity(after, before, ErrorEvents, parts);
            }
        }
        return ErrorEvents;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before)
    {
        int numberOfAttemptToSolveTask = 0;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                numberOfAttemptToSolveTask++;
            }
        }
        return numberOfAttemptToSolveTask;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before)
    {
        int numberOfSuccessfulAttemptToSolveTask = 0;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1])
                    && Status.OK.toString().equals(parts[4]))
            {
                numberOfSuccessfulAttemptToSolveTask++;
            }
        }
        return numberOfSuccessfulAttemptToSolveTask;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before)
    {
        return getTasksMap(Event.SOLVE_TASK);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before)
    {
        return getTasksMap(Event.DONE_TASK);
    }

    private Map<Integer, Integer> getTasksMap(Event event)
    {
        Map<Integer, Integer> allTasksAndTheirNumber = new HashMap<>();
        int numberOfSolvedTask;
        int value;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (event.toString().equals(parts[3].split(" ")[0]))
            {
                numberOfSolvedTask = Integer.valueOf(parts[3].split(" ")[1]);
                if (allTasksAndTheirNumber.containsKey(numberOfSolvedTask))
                {
                    value = allTasksAndTheirNumber.get(numberOfSolvedTask) + 1;
                    allTasksAndTheirNumber.put(numberOfSolvedTask, value);
                } else
                {
                    allTasksAndTheirNumber.put(numberOfSolvedTask, 1);
                }
            }
        }
        return allTasksAndTheirNumber;
    }

    @Override
    public Set<Object> execute(String query)
    {
        String field1 = "";
        String field2 = "";
        String value1 = "";
        String value2 = "";
        String value3 = "";

        List<String> values = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"[\\w \\.:]+\"");
        Matcher matcher = pattern.matcher(query);
        while (matcher.find())
        {
            values.add(matcher.group().replace("\"", ""));
        }

        if (query.split(" ").length > 2)
        {
            field1 = query.split(" ")[1];
            field2 = query.split(" ")[3];
            value1 = values.get(0);
            if (values.size() > 1)
            {
                value2 = values.get(1);
                value3 = values.get(2);
            }
        }

        Set<Object> querySet = new HashSet<>();
        for (String line : linesList)
        {
            String[] lineParts = line.split("\\t");
            if (values.size() == 0)
            {
                switch (query)
                {
                    case "get ip":
                        querySet.add(lineParts[0]);
                        break;
                    case "get user":
                        querySet.add(lineParts[1]);
                        break;
                    case "get date":
                        Date date = getDate(lineParts[2]);
                        querySet.add(date);
                        break;
                    case "get event":
                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                        querySet.add(event);
                        break;
                    case "get status":
                        Status status = Status.valueOf(lineParts[4]);
                        querySet.add(status);
                        break;
                }
            } else
            {
                switch (field1)
                {
                    case "ip":
                        switch (field2)
                        {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            querySet.add(lineParts[0]);
                                        }
                                    } else
                                    {
                                        querySet.add(lineParts[0]);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            querySet.add(lineParts[0]);
                                        }
                                    } else
                                    {
                                        querySet.add(lineParts[0]);
                                    }
                                }
                                break;
                        }
                        break;
                    case "user":
                        switch (field2)
                        {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            querySet.add(lineParts[1]);
                                        }
                                    } else
                                    {
                                        querySet.add(lineParts[1]);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            querySet.add(lineParts[1]);
                                        }
                                    } else
                                    {
                                        querySet.add(lineParts[1]);
                                    }
                                }
                                break;
                        }
                        break;
                    case "date":
                        switch (field2)
                        {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            date = getDate(lineParts[2]);
                                            querySet.add(date);
                                        }
                                    } else
                                    {
                                        Date date = getDate(lineParts[2]);
                                        querySet.add(date);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            date = getDate(lineParts[2]);
                                            querySet.add(date);
                                        }
                                    } else
                                    {
                                        Date date = getDate(lineParts[2]);
                                        querySet.add(date);
                                    }
                                }
                                break;
                        }
                        break;
                    case "event":
                        switch (field2)
                        {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                            querySet.add(event);
                                        }
                                    } else
                                    {
                                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                        querySet.add(event);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                            querySet.add(event);
                                        }
                                    } else
                                    {
                                        Event event = Event.valueOf(lineParts[3].split(" ")[0]);
                                        querySet.add(event);
                                    }
                                }
                                break;
                        }
                        break;
                    case "status":
                        switch (field2)
                        {
                            case "ip":
                            case "user":
                            case "date":
                            case "status":
                                if (value1.equals(lineParts[getField2Index(field2)]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            Status status = Status.valueOf(lineParts[4]);
                                            querySet.add(status);
                                        }
                                    } else
                                    {
                                        Status status = Status.valueOf(lineParts[4]);
                                        querySet.add(status);
                                    }
                                }
                                break;
                            case "event":
                                if (value1.equals(lineParts[3].split(" ")[0]))
                                {
                                    if (values.size() == 3)
                                    {
                                        Date date = getDate(lineParts[2]);
                                        if (isCompatibleDate(date.getTime(), getDate(value2), getDate(value3)))
                                        {
                                            Status status = Status.valueOf(lineParts[4]);
                                            querySet.add(status);
                                        }
                                    } else
                                    {
                                        Status status = Status.valueOf(lineParts[4]);
                                        querySet.add(status);
                                    }
                                }
                                break;
                        }
                        break;
                }
            }
        }
        return querySet;
    }

    private int getField2Index(String field2)
    {
        switch (field2)
        {
            case "ip":
                return 0;
            case "user":
                return 1;
            case "date":
                return 2;
            case "event":
                return 3;
            case "status":
                return 4;
        }
        return -1;
    }
}