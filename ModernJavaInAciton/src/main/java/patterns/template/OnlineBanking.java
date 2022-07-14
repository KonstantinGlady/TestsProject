package patterns.template;

public abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer c = Database.getCustomerById(id);
        makeCustomerHappy(c);
    }

    public abstract void makeCustomerHappy(Customer c);

    static private class Customer {
    }

    static private class Database {
        public static Customer getCustomerById(int id) {
            return new Customer();
        }
    }
}
