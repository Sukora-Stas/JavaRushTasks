package com.javarush.task.task39.task3913.query;

import java.util.Set;

/**
 * Created by Sukora Stas.
 */
public interface QLQuery {
    Set<Object> execute(String query);
}
