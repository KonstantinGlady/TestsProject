package chapter08.practice1.observer;

public interface FireStationRegister {
    void registerFireStation(FireObserver fo);
    void notifyFireStation(String address);
}
