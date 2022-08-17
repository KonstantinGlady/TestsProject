package chapter02;

import java.awt.*;
import java.util.Objects;

public class Car {
    private String name;
    private Color color;
    private String mark;

    public Car(String name, Color color, String mark) {
        this.name = Objects.requireNonNull(name, "Car name cannot be null");
        this.color = Objects.requireNonNull(color);

        if (mark == null) {
            throw new NullPointerException("Mark cannot be null");
        }
    }

}
