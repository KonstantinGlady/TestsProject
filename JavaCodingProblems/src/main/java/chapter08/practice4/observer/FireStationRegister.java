package chapter08.practice4.observer;

public interface FireStationRegister {
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);
}
