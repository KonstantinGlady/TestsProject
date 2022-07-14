package patterns.observer;

public class NYTimes implements Observer {
    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("New York Times todat: " + tweet);
        }
    }
}
