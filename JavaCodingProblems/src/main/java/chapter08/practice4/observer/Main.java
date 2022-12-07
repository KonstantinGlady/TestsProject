package chapter08.practice4.observer;

public class Main {

    public static void main(String[] args) {

        FireStation station = new FireStation();
        station.registerFireStation(new DecatureFireStation());
        station.registerFireStation(new ViningsFireStation());
        station.registerFireStation(new BrookhavenFireStation());
        station.notifyFireStations("Alert: fire on Decature 123");

        //lambda
        FireStation lambda = new FireStation();
        lambda.registerFireStation(s -> {
            if (s.contains("Decature")) System.out.println("Decature fire station will go to the fire");
        });
        lambda.registerFireStation(s -> {
            if (s.contains("Brookhave")) System.out.println("Brookhaven fire station will go to the fire");
        });
        lambda.registerFireStation(s -> {
            if (s.contains("Vinings")) System.out.println("Vinings fire station will go to the fire");
        });
        lambda.notifyFireStations("alert: fire on Brookhaven");
    }
}
