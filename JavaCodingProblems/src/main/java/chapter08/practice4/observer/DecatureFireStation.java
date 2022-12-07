package chapter08.practice4.observer;

public class DecatureFireStation implements FireObserver{
    @Override
    public void fire(String address) {
        if(address.contains("Decature")) System.out.println("Decature fire station will go to the fire");
    }
}
