package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Sukora Stas.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<Cook>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Date, Double> getTotalMoneyPerDay() {
        Map<Date, Double> result = new TreeMap<Date, Double>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        Double amount;
        Date date;
        Calendar calendar;
        for (EventDataRow eventDataRow : eventDataRowList) {
            VideoSelectedEventDataRow adVideo = (VideoSelectedEventDataRow) eventDataRow;
            amount = adVideo.getAmount() * 0.01d;
            calendar = Calendar.getInstance();
            calendar.setTime(adVideo.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            if (result.containsKey(date))
                amount += result.get(date);
            result.put(date, amount);
        }
        return result;
    }

    public Map<Date, Map<String, Integer>> getCookInfo() {
        Map<Date, Map<String, Integer>> result = new TreeMap<Date, Map<String, Integer>>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.COOKED_ORDER);
        Date date;
        Calendar calendar;
        String cookName;
        int cookingTimeSeconds;
        for (EventDataRow eventDataRow : eventDataRowList) {
            CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) eventDataRow;
            calendar = Calendar.getInstance();
            calendar.setTime(cookedOrder.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            cookName = cookedOrder.getCookName();
            cookingTimeSeconds = cookedOrder.getTime();
            Map<String, Integer> cookTime = new TreeMap<String, Integer>();
            if (result.containsKey(date)) {
                cookTime = result.get(date);
                if (cookTime.containsKey(cookName)) {
                    cookingTimeSeconds += cookTime.get(cookName);
                }
            }
            cookTime.put(cookName, cookingTimeSeconds);
            result.put(date, cookTime);
        }
        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<EventType, List<EventDataRow>>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            List<EventDataRow> eventDataRows = storage.get(data.getType());
            eventDataRows.add(data);
            storage.put(data.getType(), eventDataRows);
        }

        private List<EventDataRow> get(EventType eventType) {
            return storage.get(eventType);
        }
    }
}
