package chapter08.practice1.observer;

public class BrookhavenFireStation implements FireObserver{
    @Override
    public void fire(String address) {
        if (address.contains("Brookhaven")) {
            System.out.println("Brookhaven station will go to the fire");
        }
    }
}
