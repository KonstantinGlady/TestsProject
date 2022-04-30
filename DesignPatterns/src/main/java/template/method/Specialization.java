package template.method;

public abstract class Specialization extends Generalization {

    @Override
    protected void stepThree() {
        step3_1();
        step3_2();
        step3_3();
    }

    protected void step3_1() {
        System.out.println("Specialization.step3_1");
    }

    protected abstract void step3_2();

    private void step3_3() {
        System.out.println("Specialization.step3_3");
    }
}
