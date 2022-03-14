package com.gik.testsProject.paterns.builders;

import com.gik.testsProject.paterns.builders.parts.Body;
import com.gik.testsProject.paterns.builders.parts.Engine;
import com.gik.testsProject.paterns.builders.parts.Transmission;
import com.gik.testsProject.paterns.builders.parts.Wheels;

public class Car {
    private Engine engine;
    private Body body;
    private Transmission transmission;
    private Wheels wheels;

    public static class Builder {

        private Engine engine;
        private Body body;
        private Transmission transmission;
        private Wheels wheels;

        public Builder addEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder addBody(Body body) {
            this.body = body;
            return this;
        }

        public Builder addTransmission(Transmission transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder addWheels(Wheels wheels) {
            this.wheels = wheels;
            return this;
        }

        public Car build() {
            return new Car();
        }
    }
}
