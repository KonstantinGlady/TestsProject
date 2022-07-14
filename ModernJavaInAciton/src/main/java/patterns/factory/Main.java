package patterns.factory;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("stock");
        System.out.printf("p1 %s%n", p1.getClass().getSimpleName());

        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();
        System.out.printf("p2 %s%n", p2.getClass().getSimpleName());

        Product p3 = ProductLambdaFactory.createProduct("bond");
        System.out.printf("p3 %s%n ", p3.getClass().getSimpleName());
    }
}
