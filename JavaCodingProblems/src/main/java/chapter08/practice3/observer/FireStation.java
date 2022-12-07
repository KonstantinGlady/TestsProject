package chapter08.practice3.observer;

import java.util.ArrayList;
import java.util.List;

public class FireStation implements FireStationRegister {

    private List<FireObserver> fireObservers = new ArrayList<>();


    @Override
    public void registerFireStation(FireObserver fo) {
        if (fo != null) fireObservers.add(fo);
    }

    @Override
    public void notifyFireStations(String address) {
        if (address != null) fireObservers.forEach(f -> f.fire(address));
    }
}
