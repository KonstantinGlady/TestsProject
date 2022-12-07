package chapter08.practice3.command;

public class HardDisc implements IODevice {

    @Override
    public void copy() {
        System.out.println("copying..");
    }

    @Override
    public void delete() {
        System.out.println("deleting..");
    }

    @Override
    public void move() {
        System.out.println("moving..");
    }
}
