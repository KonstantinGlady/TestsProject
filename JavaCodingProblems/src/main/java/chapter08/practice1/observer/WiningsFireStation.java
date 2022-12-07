package chapter08.practice1.observer;

public class WiningsFireStation implements FireObserver {
    @Override
    public void fire(String address) {
        if (address.contains("Winings")) {
            System.out.println("Winings fire station will go to the fire");
        }
    }
}
