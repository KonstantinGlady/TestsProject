package com.gik.testsProject.paterns.builders;

import com.gik.testsProject.paterns.builders.parts.Body;
import com.gik.testsProject.paterns.builders.parts.Engine;
import com.gik.testsProject.paterns.builders.parts.Transmission;
import com.gik.testsProject.paterns.builders.parts.Wheels;

public class Main {

    public static void main(String[] args) {

        Car car = new Car.Builder()
                .addBody(new Body())
                .addEngine(new Engine())
                .addTransmission(new Transmission())
                .addWheels(new Wheels())
                .build();
        System.out.println(car);
    }
}
