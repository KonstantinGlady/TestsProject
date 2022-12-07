package chapter08.practice2.command;

import java.util.NoSuchElementException;

public class HardDrive implements IODevice {
    @Override
    public void delete() {
        System.out.println("deleting..");
    }

    @Override
    public void move() {
        System.out.println("moving...");
    }

    @Override
    public void copy() {
        System.out.println("copying..");
    }
}
