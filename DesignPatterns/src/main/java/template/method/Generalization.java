package template.method;

public abstract class Generalization {

    public  void findSolution() {
        stepOne();
        stepTwo();
        stepThree();
        stepFour();
    }

    private void stepOne() {
        System.out.println("Generalization.stepOne");
    }

    protected abstract void stepTwo();

    protected abstract void stepThree();

    protected  void stepFour() {
        System.out.println("Generalization.stepFour");
    }
}
