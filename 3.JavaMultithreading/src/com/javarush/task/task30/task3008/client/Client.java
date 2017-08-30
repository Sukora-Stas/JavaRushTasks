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

    /**
     * PSVM Client
     **/
    public static void main(String[] args) {

        Client client = new Client();
        client.run();
    }


    public class SocketThread extends Thread {

        /**
         * Этот метод будет реализовывать главный цикл обработки сообщений сервера
         **/
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            while (true) {

                // В цикле получать сообщения, используя соединение connection
                Message message = connection.receive();

                if (!(message.getType() == MessageType.TEXT) &&
                        !(message.getType() == MessageType.USER_ADDED) &&
                        !(message.getType() == MessageType.USER_REMOVED)) {
                    throw new IOException("Unexpected MessageType");
                }

                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());

                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());


                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());

                }

//                switch (message.getType()) {
//
//                    // Если это текстовое сообщение (тип TEXT), обработай его с помощью метода processIncomingMessage()
//                    case TEXT:
//                        processIncomingMessage(message.getData());
//                        break;
//
//                    // Если это сообщение с типом USER_ADDED, обработай его с помощью метода informAboutAddingNewUser()
//                    case USER_ADDED:
//                        informAboutAddingNewUser(message.getData());
//                        break;
//
//                    // Если это сообщение с типом USER_REMOVED, обработай его с помощью метода informAboutDeletingNewUser()
//                    case USER_REMOVED:
//                        informAboutDeletingNewUser(message.getData());
//                        break;
//
//                    default:
//                        throw new IOException("Unexpected MessageType");
//                }
            }
        }

        /**
         * clientHandshake
         **/
        protected void clientHandshake() throws IOException, ClassNotFoundException {

            while (true) {

                // В цикле получать сообщения, используя соединение connection
                Message message = connection.receive();


                if (message.getType() == MessageType.NAME_REQUEST) {

                    connection.send(new Message(MessageType.USER_NAME, getUserName()));

                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
//                (!(message.getType() == MessageType.NAME_REQUEST) &&
//                        !(message.getType() == MessageType.NAME_ACCEPTED))

//                switch (message.getType()) {
//
//                    // 	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя)
//                    case NAME_REQUEST: {
//
//                        // запросить ввод имени пользователя с помощью метода getUserName()
//                        // создать новое сообщение с типом USER_NAME и введенным именем, отправить сообщение серверу.
//                        String userName = getUserName();
//                        connection.send(new Message(MessageType.USER_NAME, userName));
//                        break;
//                    }
//
//                    // Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя)
//                    case NAME_ACCEPTED: {
//
//                        // значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
//                        // Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
//                        notifyConnectionStatusChanged(true);
//                        return;
//                    }
//
//                    default: {
//                        throw new IOException("Unexpected MessageType");
//                    }
//                }
            }
        }

        /**
         * должен выводить текст message в консоль
         **/
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }


        /**
         * должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату
         **/
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("участник " + userName + " присоединился к чату");
        }


        /**
         * должен выводить в консоль, что участник с именем userName покинул чат
         **/
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("участник " + userName + " покинул чат");
        }


        /**
         * Устанавливать значение поля clientConnected класса Client в соответствии с
         * переданным параметром.
         * Оповещать (пробуждать ожидающий) основной поток класса Client
         **/
        protected void notifyConnectionStatusChanged(boolean clientConnected) {


            Client.this.clientConnected = clientConnected;

            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }


    /** Methods **/
    /**
     * run
     **/
    public void run() {

        // Создавать новый сокетный поток с помощью метода getSocketThread
        SocketThread socketThread = getSocketThread();
        // Помечать созданный поток как daemon, это нужно для того, чтобы при выходе
        // из программы вспомогательный поток прервался автоматически.
        socketThread.setDaemon(true);
        // Запустить вспомогательный поток
        socketThread.start();

        // Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка");
            return;
        }

        //После того, как поток дождался нотификации, проверь значение clientConnected
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

            //Считывай сообщения с консоли пока клиент подключен. Если будет введена команда 'exit', то выйди из цикла
            while (clientConnected) {
                String message;
                if (!(message = ConsoleHelper.readString()).equals("exit")) {
                    if (shouldSendTextFromConsole()) {
                        sendTextMessage(message);
                    }
                } else {
                    return;
                }
            }
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
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
