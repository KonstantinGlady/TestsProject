package chapter08.practice3.observer;

public class Main {

    public static void main(String[] args) {

        //oop
        FireStationRegister station = new FireStation();
        station.registerFireStation(new BrookhavenFireStation());
        station.registerFireStation(new DecatureFireStation());
        station.registerFireStation(new ViningsFireStation());
        station.notifyFireStations("alert: fire on Decature 234 str.");

        FireStationRegister fsr = new FireStation();
        fsr.registerFireStation(o -> {
            if (o.contains("Decature")) System.out.println("Decature station will go to the fire");
        });
        fsr.registerFireStation(o -> {
            if (o.contains("Brookhaven")) System.out.println("Brookhaven fire station will go to the fire");
        });
        fsr.notifyFireStations("alert: Decature in fire");
    }
}
