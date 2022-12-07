package chapter08.practice4.observer;

public class BrookhavenFireStation implements FireObserver{
    @Override
    public void fire(String address) {
        if(address.contains("Brookhaven")) System.out.println("Brookhaven fire station will go to the fire");
    }
}
