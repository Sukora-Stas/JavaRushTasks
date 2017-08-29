package com.javarush.task.task36.task3608.model;

/**
 * Created by Sukora Stas.
 */
public interface Model {
    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    public void loadUserById(long userId);

    void deleteUserById(long id);

    void changeUserData(String name, long id, int level);
}
