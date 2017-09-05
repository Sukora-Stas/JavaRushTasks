package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Sukora Stas.
 */
public class DirectorTablet {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        //какую сумму заработали на рекламе, сгруппировать по дням
        double total = 0d;
        StatisticManager statisticManager = StatisticManager.getInstance();
        for (Map.Entry<Date, Double> map : statisticManager.getTotalMoneyPerDay().entrySet()) {
            double profit = (double) map.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", simpleDateFormat.format(map.getKey()), profit));
            total += profit;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }

    public void printCookWorkloading() {
        //загрузка (рабочее время) повара, сгруппировать по дням
        StatisticManager statisticManager = StatisticManager.getInstance();
        for (Map.Entry<Date, Map<String, Integer>> pair : statisticManager.getCookInfo().entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", pair2.getKey(), pair2.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        if (StatisticAdvertisementManager.getInstance().getActiveVideoSet().isEmpty()) return;
        for (Map.Entry<String, Integer> pair : StatisticAdvertisementManager.getInstance().getActiveVideoSet().entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %d", pair.getKey(), pair.getValue()));
        }
    }

    public void printArchivedVideoSet() {
        List<Advertisement> inactiveVideos = StatisticAdvertisementManager.getInstance().getInactiveVideoSet();
        Collections.sort(inactiveVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : inactiveVideos) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
