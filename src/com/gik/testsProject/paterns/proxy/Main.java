package com.gik.testsProject.paterns.proxy;

public class Main {
    public static void main(String[] args) {
        CarProxy car = new CarProxy(new Car(50), true);
        car.speedUp();
        car.speedDown();
    }
}

interface Movable {
    void speedUp();

    void speedDown();
}

class Car implements Movable {

    int speed;

    public Car(int speed) {
        this.speed = speed;
    }

    @Override
    public void speedUp() {
        if (speed < 50) {
            speed++;
        }
    }

    @Override
    public void speedDown() {
        if (speed > 0) {
            speed--;
        }
    }

}

class CarProxy {
     Car car;
     boolean haveLicense;

    public CarProxy(Car car, boolean license) {
        this.car = car;
        this.haveLicense = license;
    }

    public void speedUp() {
        if (haveLicense) {
            car.speedUp();
        }
    }

    public void speedDown() {
        if (haveLicense) {
            car.speedDown();
        }
    }
}
