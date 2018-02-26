package com.javarush.task.task36.task3601;

/**
 * Created by Sukora Stas.
 */
public class View {
    private static Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
