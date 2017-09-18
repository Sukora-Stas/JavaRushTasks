package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage= AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {

    }

    public List<Advertisement> getActiveVideos() {
        List<Advertisement> list=new ArrayList<>();
        for (int i = 0; i<advertisementStorage.list().size(); i++)
        {
            if (advertisementStorage.list().get(i).getHits()>0)
                list.add(advertisementStorage.list().get(i));
        }
        return list;
    }

    public List<Advertisement> getArchivedVideos() {
        List<Advertisement> list=new ArrayList<>();
        for (int i = 0; i<advertisementStorage.list().size(); i++)
        {
            if (advertisementStorage.list().get(i).getHits()<=0)
                list.add(advertisementStorage.list().get(i));
        }
        return list;
    }
}
