package com.javarush.task.task36.task3608.model;

/**
 * Created by Sukora Stas.
 */
public interface Model {
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();
}
