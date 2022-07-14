package patterns.observer;

public class Main {

    public static void main(String[] args) {

        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardians());
        f.registerObserver(new LeMode());
        f.notifyObservers("The queen said her favourite book is Java 8 & 9 in Action!");

        //lambda
        Feed fLambda = new Feed();

        fLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Today from Guardian: " + tweet);
            }
        });

        fLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Today from New York Times: " + tweet);
            }
        });

        fLambda.notifyObservers("Money, money only money!");
    }
}
