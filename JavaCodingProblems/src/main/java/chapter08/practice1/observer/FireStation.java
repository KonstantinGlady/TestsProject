package chapter08.practice1.observer;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister {

    private final List<FireObserver> fireObservers = new ArrayList<>();

    @Override
    public void registerFireStation(FireObserver fo) {
        if (fo != null) {
            fireObservers.add(fo);
        }
    }

    @Override
    public void notifyFireStation(String address) {
        if (address != null) {
            for (FireObserver fo : fireObservers) {
                fo.fire(address);
            }
        }
    }
}
