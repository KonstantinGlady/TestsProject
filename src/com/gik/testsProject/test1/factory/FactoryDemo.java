package com.gik.testsProject.test1.factory;

public class FactoryDemo {


    public static void main(String[] args) {
        Car ford = CarFactory.makeCar("ford", 123, new Engine());
        System.out.println(ford);
    }
}

class Engine {
}

class Car {
    String prod;
    int id;
    Engine engine;

    public Car(String prod, int id, Engine engine) {
        this.prod = prod;
        this.id = id;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "prod='" + prod + '\'' +
                ", id=" + id +
                ", engine=" + engine +
                '}';
    }
}

class CarFactory {
    public static Car makeCar(String prod, int id, Engine engine) {
        return new Car(prod, id, engine);
    }
}



