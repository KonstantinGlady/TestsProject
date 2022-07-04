package transactions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Trader Alan = new Trader("Alan", "Milan");
        Trader Mark = new Trader("Mark", "London");
        Trader Jonathan = new Trader("Jonathan", "Cambridge");
        Trader Lina = new Trader("Lina", "Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(Alan, 2010, 33333),
                new Transaction(Mark, 2011, 32345),
                new Transaction(Jonathan, 2012, 38992),
                new Transaction(Mark, 2009, 12001),
                new Transaction(Jonathan, 2013, 88888),
                new Transaction(Alan, 2014, 33333),
                new Transaction(Lina, 2012, 65345),
                new Transaction(Alan, 2011, 38232),
                new Transaction(Mark, 2011, 65001),
                new Transaction(Mark, 2014, 88438)
        );


        filter2011(transactions);

        uniqueCities(transactions);

        tradersFromCambridge(transactions);

        tradersNamesToString(transactions);

        isAnyTraderFromMilan(transactions);

        sumForCambridge(transactions);

        maxTransaction(transactions);

        minTransaction(transactions);

    }

    private static void minTransaction(List<Transaction> transactions) {
        System.out.println(transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)));
    }

    private static void maxTransaction(List<Transaction> transactions) {
        Optional<Integer> max =  transactions.stream()
                 .map(Transaction::getValue)
                 .max(Comparator.naturalOrder());
        max.ifPresent( System.out::println);
    }

    private static void sumForCambridge(List<Transaction> transactions) {
        int sum = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, (i, j) -> i += j);
        System.out.println("Sum for Cambridge: " +sum);
    }

    private static void isAnyTraderFromMilan(List<Transaction> transactions) {
        System.out.println("is any trader from Milan?: " +
                transactions.stream()
                .anyMatch(tr -> tr.getTrader()
                        .getCity()
                        .equals("Milan")));
    }

    private static void tradersNamesToString(List<Transaction> transactions) {
        String s = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .reduce(" ",(i, j) -> i  + j);
        System.out.println(s);
    }

    private static void tradersFromCambridge(List<Transaction> transactions) {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    private static void uniqueCities(List<Transaction> transactions) {
        transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    private static void filter2011(List<Transaction> transactions) {
        List<Transaction> sortedList = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }
}
