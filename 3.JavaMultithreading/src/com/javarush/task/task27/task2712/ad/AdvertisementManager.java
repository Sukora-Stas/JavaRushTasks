package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage=AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> videoList=new ArrayList<>(storage.list());
        if (videoList.size()==0)
            throw new NoVideoAvailableException();

        Collections.sort(videoList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;

                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        long sumAmount=0;
        int sumDuration=0;

        List<Advertisement> list=new ArrayList<>();

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : videoList) {
            if (timeLeft < advertisement.getDuration() || advertisement.getHits()<=0) {
                continue;
            }
            list.add(advertisement);
            sumAmount+=advertisement.getAmountPerOneDisplaying();
            sumDuration+=advertisement.getDuration();
            timeLeft -= advertisement.getDuration();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(list, sumAmount, sumDuration));

        for (Advertisement advertisement : list) {
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
            advertisement.revalidate();
        }
    }
}

