package com.javarush.task.task25.task2510;

/**
 * Created by Sukora Stas.
 */
public class Test implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        String stars = t.getName().replaceAll(".", "*");
        String newMessage = e.getMessage().replace(t.getName(), stars);
        e = new Exception(newMessage, e);
        System.out.println(e.getMessage());
        t.setName(stars);
    }

    public static void main(String args[])
    {
        Test test = new Test();
        Thread myThread = new Thread("thread-02");
        test.uncaughtException(myThread, new Exception("Blah " + myThread.getName() + " blah-blah-blah", new NullPointerException()));
    }
}
