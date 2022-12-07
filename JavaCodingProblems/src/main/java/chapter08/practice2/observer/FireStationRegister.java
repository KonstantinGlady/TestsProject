package chapter08.practice2.observer;

public interface FireStationRegister {
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);
}
