package patterns.observer;

public class LeMode implements Observer {
    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today for la Mode: " + tweet);
        }
    }
}
