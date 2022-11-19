package chapter08.observer;

public class OneFireStation implements FireObserver {
    @Override
    public void fire(String address) {
        if (address.contains("One")) {
            System.out.println("OneStation will go to this fire");
        }
    }
}
