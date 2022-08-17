package chapter02.iae;

import java.awt.*;

public class Car {

    private String name;
    private Color color;

    public Car(String name, Color color) {
        this.name = MyObjects.requireNonNullElseThrow(name, new UnsupportedOperationException("Name cannot be set as null"));
        this.color = MyObjects.requireNotNullElseThrow(color,
                () -> new UnsupportedOperationException("Color cannot be set as null"));
    }

    public void assignDriver(String license, String region) {
        MyObjects.requireNonNullElseThrowIAE(license, "license cannot be null");
        MyObjects.requireNonNullElseThrowIAE(region, () -> "region cannot be null");
    }
}
