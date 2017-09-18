package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by Serhii Boiko on 08.07.2017.
 */
public class VideoSelectedEventDataRow implements EventDataRow{
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    private Date currentDate;

    public long getAmount() {
        return amount;
    }

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
    {
        currentDate = new Date();
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
    }
    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
