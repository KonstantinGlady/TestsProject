package chapter08.observer;

public class SecondFireStation implements FireObserver {
    @Override
    public void fire(String address) {
        if (address.contains("Second")) {
            System.out.println("SecondStation will go to this fire");
        }
    }
}
