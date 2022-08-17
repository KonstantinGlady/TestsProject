package chapter02.byDefault;

import java.awt.*;
import java.util.Objects;

public class Car {
    private String name;
    private Color color;

    public Car(String name, Color color) {
        this.name = Objects.requireNonNullElse(name, "no name");
        this.color = Objects.requireNonNullElseGet(color, () -> new Color(0, 0, 0));
    }
}
