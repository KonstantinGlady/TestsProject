package chapter08.observer;

public class Main {

    public static void main(String[] args) {

        FireStation fireStation = new FireStation();
        //base
      /*  fireStation.registerFireStation(new OneFireStation());
        fireStation.registerFireStation(new SecondFireStation());
        fireStation.notifyFireStation("One in fire");*/

        //functional approach
        fireStation.registerFireStation((String s) -> {
            if (s.contains("One")) {
                System.out.println("OneStation will go to this fire");
            }
        });

        fireStation.registerFireStation((String s) -> {
            if (s.contains("Second")) {
                System.out.println("SecondStation will go to this fire");
            }
        });
        fireStation.notifyFireStation("Second in fire");
    }
}
