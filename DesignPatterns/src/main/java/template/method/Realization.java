package template.method;

public class Realization extends Specialization {
    @Override
    protected void stepTwo() {
        System.out.println("Realization.stepTwo");
    }

    @Override
    protected void step3_2() {
        System.out.println("Realization.step3_2");
    }

    @Override
    protected void stepFour() {
        System.out.println("Realization.stepFour");
        super.stepFour();
    }
}
