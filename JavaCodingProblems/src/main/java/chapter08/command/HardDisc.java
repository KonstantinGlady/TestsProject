package chapter08.command;

public class HardDisc implements IODevice {
    @Override
    public void copy() {
        System.out.println("hard disc copy");
    }

    @Override
    public void move() {
        System.out.println("hard disc move");
    }

    @Override
    public void delete() {
        System.out.println("hard disc delete");
    }
}
