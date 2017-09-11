package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by Sukora Stas.
 */
public class Shortener {
    private Long lastId;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.lastId = 0L;
        this.storageStrategy = storageStrategy;
    }

    public synchronized  Long getId(String string){
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
        }

        return lastId;
    }

    public synchronized  String getString(Long id){
        return storageStrategy.getValue(id);
    }

}
