package chapter08.practice4.command;

public class HardDisk implements IODevice {
    @Override
    public void copy() {
        System.out.println("coping..");
    }

    @Override
    public void move() {
        System.out.println("moving..");
    }

    @Override
    public void delete() {
        System.out.println("deleting..");
    }
}
