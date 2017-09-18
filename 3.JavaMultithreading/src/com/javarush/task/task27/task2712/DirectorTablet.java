package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Sukora Stas.
 */
public class DirectorTablet {
    private DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

    public void printAdvertisementProfit()
    {
        double total = 0d;
        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().getAdRevenue().entrySet()) {
            double profit = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", df.format(entry.getKey()), profit));
            total += profit;
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }
    public void printCookWorkloading()
    {
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticManager.getInstance().getCookWorkload().entrySet()) {
            ConsoleHelper.writeMessage(df.format(entry.getKey()));
            for (Map.Entry<String, Integer> cooksEntry : entry.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cooksEntry.getKey(), cooksEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet()
    {
        List<Advertisement> activeVideos = StatisticAdvertisementManager.getInstance().getActiveVideos();
        Collections.sort(activeVideos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : activeVideos) {
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
    }
    public void printArchivedVideoSet()
    {
        List<Advertisement> archivedVideos = StatisticAdvertisementManager.getInstance().getArchivedVideos();
        Collections.sort(archivedVideos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement advertisement : archivedVideos) {
            ConsoleHelper.writeMessage(String.format("%s", advertisement.getName()));
        }
    }
}