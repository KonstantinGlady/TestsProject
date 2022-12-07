package chapter08.practice3.observer;

public class ViningsFireStation implements FireObserver{
    @Override
    public void fire(String address) {
        if(address.contains("Vinings")) System.out.println("Vinings fire station will go to the fire");
    }
}
