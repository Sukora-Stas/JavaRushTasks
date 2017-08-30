package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sukora Stas.
 */
public class ClientGuiModel {
    // Добавь в него множество(set) строк в качестве константного поля allUserNames
    private final Set<String> allUserNames = new HashSet<>();

    // Добавь поле String newMessage, в котором будет храниться новое сообщение, которое получил клиент
    private String newMessage;


    /**
     * methods
     **/
    // Добавь метод void addUser(String newUserName), который должен добавлять имя участника во множество, хранящее всех участников
    public void addUser(String newUserName) {

        allUserNames.add(newUserName);
    }


    // Добавь метод void deleteUser(String userName), который будет удалять имя участника из множества
    public void deleteUser(String userName) {

        allUserNames.remove(userName);
    }


    /**
     * getters and setters
     **/
    // Добавь геттер для allUserNames, запретив модифицировать возвращенное множество.
    // Разберись, как это можно сделать с помощью метода класса Collections
    public Set<String> getAllUserNames() {

        return Collections.unmodifiableSet(allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }
}
