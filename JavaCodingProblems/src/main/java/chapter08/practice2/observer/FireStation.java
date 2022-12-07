package chapter08.practice2.observer;

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
        for (FireObserver f : fireObservers) {
            f.fire(address);
        }
    }
}
