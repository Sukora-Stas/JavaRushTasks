package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Home;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sukora Stas.
 */
public class Field extends JPanel {
    private View view;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);

        Player player = new Player(30, 30);
        player.draw(g);

        Box box = new Box(100, 100);
        box.draw(g);

        Home home = new Home(150, 150);
        home.draw(g);
    }
}
