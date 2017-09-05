package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sukora Stas.
 */
public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public Map<String, Integer> getActiveVideoSet() {
        Map<String, Integer> res = new TreeMap<String, Integer>();
        List<Advertisement> videos = storage.list();
        for (Advertisement ad : videos) {
            if (ad.getHits() >= 1)
                res.put(ad.getName(), ad.getHits());
        }
        return res;
    }

    public List<Advertisement> getInactiveVideoSet() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() == 0) {
                result.add(advertisement);
            }
        }
        return result;
    }


//    public static void main(String[] args) {
//        Map<String, Integer> res = new TreeMap<String, Integer>();
//        res.put("second", 10);
//        res.put("First", 10);
//        res.put("четвертое", 10);
//        res.put("xxx", 10);
//        res.put("third", 10);
//        for (Map.Entry<String, Integer> m : res.entrySet()) {
//            ConsoleHelper.writeMessage(m.getKey() + " " + m.getValue());
//        }
//        List<String> r = new ArrayList<String>();
//        r.add("second");
//        r.add("First");
//        r.add("четвертое");
//        r.add("xxx");
//        r.add("third");
//        Collections.sort(r);
//        ConsoleHelper.writeMessage(r.toString());
//    }
}
