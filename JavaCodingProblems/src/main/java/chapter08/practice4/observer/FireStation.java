package chapter08.practice4.observer;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister {

    private List<FireObserver> fireObservers = new ArrayList<>();

    @Override
    public void registerFireStation(FireObserver fo) {
        fireObservers.add(fo);
    }

    @Override
    public void notifyFireStations(String address) {
        if (address == null) throw new IllegalArgumentException("params can not be null");
        fireObservers.forEach(o -> o.fire(address));
    }
}
