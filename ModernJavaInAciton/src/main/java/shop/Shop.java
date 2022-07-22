package shop;

import java.util.Random;

import static shop.Util.delay;
import static shop.Util.format;


public class Shop {

    private final String name;
    private final Random random;

    public Shop(String shopName) {
        this.name = shopName;
        this.random = new Random(shopName.charAt(0) * shopName.charAt(1) * shopName.charAt(2));
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values() [random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    private double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }

    public String getName() {
        return name;
    }
}
