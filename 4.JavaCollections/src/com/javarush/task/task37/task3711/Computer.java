package com.javarush.task.task37.task3711;

/**
 * Created by Sukora Stas.
 */
public class Computer {
    CPU cpu;
    Memory memory;
    HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void run() {


        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}