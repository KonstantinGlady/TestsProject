package patterns.factory;

public  class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan" :
                return new Loan();
            case "bond" :
                return new Bond();
            case "stock" :
                return new Stock();
            default:
                throw new RuntimeException("no such name" + name);
        }
    }
}
