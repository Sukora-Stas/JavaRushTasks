package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sukora Stas.
 */
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player;

        walls.add(new Wall(200, 200));
        walls.add(new Wall(180, 180));
        walls.add(new Wall(220, 220));
        boxes.add(new Box(240, 240));
        homes.add(new Home(80, 80));
        player = new Player(40, 40);


        return new GameObjects(walls, boxes, homes, player);

    }
}
