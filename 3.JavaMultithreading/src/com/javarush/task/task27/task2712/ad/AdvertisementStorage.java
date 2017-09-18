package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class AdvertisementStorage {
    private static AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "1", 152, 3, 3 * 60));
        videos.add(new Advertisement(someContent, "2", 5, 2, 5 * 60));
        videos.add(new Advertisement(someContent, "3", 3, 2, 3 * 60));
        videos.add(new Advertisement(someContent, "4", 99, 10, 2 * 60));
        videos.add(new Advertisement(someContent, "X", 2000, 3, 6 * 60));
        videos.add(new Advertisement(someContent, "5", 150, 3, 3 * 60));
        videos.add(new Advertisement(someContent, "1First Video", 5000, 1, 3 * 60));
        videos.add(new Advertisement(someContent, "2Second Video", 100, 1, 15 * 60));
        videos.add(new Advertisement(someContent, "3Third Video", 400, 2, 10 * 60));
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));   //10 min
    }

    public static AdvertisementStorage getInstance() {
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }
}
