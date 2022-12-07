package chapter08.practice3.observer;

public interface FireStationRegister {
    void registerFireStation(FireObserver fo);
    void notifyFireStations(String address);
}
