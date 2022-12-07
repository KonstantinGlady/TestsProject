package chapter08.practice1.command;

public class HardDisc implements IODevice {
    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void move() {
        System.out.println("move");
    }

    @Override
    public void copy() {
        System.out.println("copy");
    }
}
