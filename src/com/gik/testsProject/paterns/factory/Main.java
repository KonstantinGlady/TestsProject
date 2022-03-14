package com.gik.testsProject.paterns.factory;

public class Main {

    public static void main(String[] args) {

        Car toyota = CarFactory.makeCar(50, "blue", new Engine());
        Car volvo = CarFactory.makeCar(70, "red", new Engine());
    }
}
