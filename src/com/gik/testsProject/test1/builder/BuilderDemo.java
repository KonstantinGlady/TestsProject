package com.gik.testsProject.test1.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        Car car = new Car.Builder(new Engine())
                .addBreaks(new Breaks())
                .addDoors(new Doors())
                .addWheels(new Wheels())
                .build();
        System.out.println(car);
    }
}

class Engine {
}

class Wheels {
}

class Doors {
}

class Breaks {
}

class Car {

    private final Engine engine;
    private final Wheels wheels;
    private final Doors doors;
    private final Breaks breaks;

    public static class Builder {

        private final Engine engine;
        private Wheels wheels;
        private Doors doors;
        private Breaks breaks;

        Builder(Engine engine) {
            this.engine = engine;
        }

        Builder addWheels(Wheels wheels) {
            this.wheels = wheels;
            return this;
        }

        Builder addDoors(Doors doors) {
            this.doors = doors;
            return this;
        }

        Builder addBreaks(Breaks breaks) {
            this.breaks = breaks;
            return this;
        }

        Car build() {
            return new Car(this);
        }
    }

    private Car(Builder builder) {
        engine = builder.engine;
        wheels = builder.wheels;
        doors = builder.doors;
        breaks = builder.breaks;
    }

}

