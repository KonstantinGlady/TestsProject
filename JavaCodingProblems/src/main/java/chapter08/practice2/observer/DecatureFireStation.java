package chapter08.practice2.observer;

public class DecatureFireStation implements FireObserver{
    @Override
    public void fire(String address) {
        if (address.contains("Decature")) {
            System.out.println("Decature station will go to the fire");
        }
    }
}
