package com.javarush.task.task33.task3310.strategy;

import org.apache.commons.collections4.bidimap.DualHashBidiMap;

/**
 * Created by Sukora Stas.
 */
public class DualHashBidiMapStorageStrategy implements StorageStrategy {

    private DualHashBidiMap<Long, String> data = new DualHashBidiMap<>();
    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }
    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }
    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }
    @Override
    public Long getKey(String value) {
        return data.getKey(value);
    }
    @Override
    public String getValue(Long key) {
        return data.get(key);
    }

}
