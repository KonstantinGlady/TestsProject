package chapter08.practice2.observer;

public class ViningsFireStation implements FireObserver {
    @Override
    public void fire(String address) {
        if (address.contains("Vinings")) {
            System.out.println("Vinings station will go the fire");
        }
    }
}
