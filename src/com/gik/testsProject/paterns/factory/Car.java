package com.gik.testsProject.paterns.factory;

public class Car implements Moveable {

    String color;
    int speed;
    Engine engine;

    public Car(int speed, String color, Engine engine) {
        this.color = color;
        this.speed = speed;
        this.engine = engine;
    }

    @Override
    public void start() {
        if (speed < 0) {
            speed++;
        }
    }

    @Override
    public void stop() {
        if (speed > 0) {
            speed--;
        }
    }
}
