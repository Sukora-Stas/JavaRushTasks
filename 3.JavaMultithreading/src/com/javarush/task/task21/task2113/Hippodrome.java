package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sukora Stas.
 */
public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;


    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());

        game.getHorses().add(new Horse("Ben", 3, 0));
        game.getHorses().add(new Horse("Jack", 3, 0));
        game.getHorses().add(new Horse("Nick", 3, 0));

        game.run();
        game.printWinner();
    }

    public Horse getWinner() {
        double maxDistance = 0;
        Horse winner = null;
        for (Horse h : getHorses()) {
            if (h.getDistance() > maxDistance) {
                maxDistance = h.getDistance();
                winner = h;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }

    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }

    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
}
