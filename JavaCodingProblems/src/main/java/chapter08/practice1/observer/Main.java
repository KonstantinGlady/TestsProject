package chapter08.practice1.observer;

public class Main {

    public static void main(String[] args) {

        FireStation fireStation = new FireStation();

        //oop
      /*  fireStation.registerFireStation(new BrookhavenFireStation());
        fireStation.registerFireStation(new WiningsFireStation());
        fireStation.registerFireStation(new DecatureFireStation());*/

        //function
        fireStation.registerFireStation(address -> {
            if (address.contains("Brookhaven")) {
                System.out.println("Brookhaven fire station will go to the fire");
            }
        });

        fireStation.registerFireStation(address -> {
            if (address.contains("Decature")) {
                System.out.println("Decature fire station will go to the fire");
            }
        });

        fireStation.notifyFireStation("fire alarm: fire at Brookhaven address 123 43");
    }
}
