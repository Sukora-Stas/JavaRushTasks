package com.javarush.task.task27.task2712.ad;

/**
 * Created by Sukora Stas.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    private long amountPerOneDisplaying;


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

//        if (hits > 0) amountPerOneDisplaying = (long) (initialAmount * 1.0 / hits);
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        hits--;
    }
}
