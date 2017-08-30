package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/**
 * Created by Sukora Stas.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

    }

    /**
     * Должен запросить ввод адреса сервера и вернуть введенное значение
     **/
    protected String getServerAddress() {

        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        return ConsoleHelper.readString();
    }


    /**
     * Должен запрашивать ввод порта сервера и возвращать его
     **/
    protected int getServerPort() {

        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }


    /**
     * Должен запрашивать и возвращать имя пользователя
     **/
    protected String getUserName() {

        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }


    protected boolean shouldSendTextFromConsole() {

        return true;
    }


    /**
     * должен создавать и возвращать новый объект класса SocketThread
     **/
    protected SocketThread getSocketThread() {

        return new SocketThread();
    }


    /**
     * создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection
     **/
    protected void sendTextMessage(String text) {

        try {
            connection.send(new Message(MessageType.TEXT, text));

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки");
            clientConnected = false;
        }
    }
}
