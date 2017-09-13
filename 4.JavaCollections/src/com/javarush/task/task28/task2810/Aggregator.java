package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;

import java.io.IOException;

/**
 * Created by Sukora Stas.
 */
public class Aggregator {
    public static void main(String[] args) throws IOException {
        Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        controller.scan();

    }
}
