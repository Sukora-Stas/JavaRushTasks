package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by Serhii Boiko on 08.07.2017.
 */
public interface EventDataRow {
    public EventType getType();

    public Date getDate();

    int getTime();
}
