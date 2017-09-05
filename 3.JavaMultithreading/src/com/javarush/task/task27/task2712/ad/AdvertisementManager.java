package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Sukora Stas.
 */
public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;


    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }
//    public void processVideos()
//    {
//
//        Collections.sort(storage.list(), new Comparator<Advertisement>() {
//
//            @Override
//            public int compare(Advertisement o1, Advertisement o2) {
//                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
//                if (result != 0)
//                    return -result;
//
//                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
//                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
//
//                return Long.compare(oneSecondCost1, oneSecondCost2);
//            }
//        });
//
//        int timeLeft = timeSeconds;
//        for (Advertisement advertisement : storage.list()) {
//            if (timeLeft < advertisement.getDuration()) {
//                continue;
//            }
//
//            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
//                    + advertisement.getAmountPerOneDisplaying() + ", "
//                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());
//
//            timeLeft -= advertisement.getDuration();
//            advertisement.revalidate();
//        }
//
//        if (timeLeft == timeSeconds) {
//            throw new NoVideoAvailableException();
//        }
//
//
//    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
    }


}
