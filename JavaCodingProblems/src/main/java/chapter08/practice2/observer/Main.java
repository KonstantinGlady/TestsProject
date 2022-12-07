package chapter08.practice2.observer;

public class Main {
    public static void main(String[] args) {

        //oop
        FireStation station = new FireStation();
        station.registerFireStation(new BrookhavenFireStation());
        station.registerFireStation(new ViningsFireStation());
        station.notifyFireStations("Alarm: fire Brookhaven 123 str.");

        //lambda
        FireStationRegister lambdaStation = new FireStation();
        lambdaStation.registerFireStation(address -> {
            if (address.contains("Brookhave")) System.out.println("Brookhave station will go to the fire");
        });
        lambdaStation.registerFireStation(address -> {
            if (address.contains("Decature")) System.out.println("Decature station will go to the fire");
        });
        lambdaStation.notifyFireStations("Alarm: fire Brookhaven 123 str.");
    }
}
