package chapter08.observer;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister {

    private final List<FireObserver> observers = new ArrayList<>();

    @Override
    public void registerFireStation(FireObserver fo) {
        if (fo != null) {
            observers.add(fo);
        }
    }

    @Override
    public void notifyFireStation(String address) {
        if (address != null) {
            for (FireObserver fo : observers) {
                fo.fire(address);
            }
        }
    }
}
