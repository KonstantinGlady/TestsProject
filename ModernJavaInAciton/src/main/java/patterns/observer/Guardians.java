package patterns.observer;

public class Guardians implements Observer {
    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Today from Guardian: " + tweet);
        }
    }
}
