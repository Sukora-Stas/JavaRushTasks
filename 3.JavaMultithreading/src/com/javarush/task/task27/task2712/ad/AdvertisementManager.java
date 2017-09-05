package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * Created by Sukora Stas.
 */
public class AdvertisementManager {

    private final AdvertisementStorage storage;
    private int timeSeconds;


    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
        storage = AdvertisementStorage.getInstance();
    }
    public void processVideos()
    {
        ConsoleHelper.writeMessage("calling processVideos method");
    }


}
