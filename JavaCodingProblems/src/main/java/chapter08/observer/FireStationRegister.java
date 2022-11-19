package chapter08.observer;

public interface FireStationRegister {
    void registerFireStation(FireObserver fo);
    void notifyFireStation(String address);
}
