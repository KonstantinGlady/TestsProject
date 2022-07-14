package patterns.template;


import java.util.function.Consumer;

public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerById(id);
        makeCustomerHappy.accept(c);
    }

    private static class Customer {
    }

    private static class Database {
        public static Customer getCustomerById(int id) {
            return new Customer();
        }
    }
}
