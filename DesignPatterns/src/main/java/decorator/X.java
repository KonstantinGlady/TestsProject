package decorator;

public class X extends D {
    public X(I inner) {
        super(inner);
    }

    @Override
    public void doIt() {
        super.doIt();
        doX();
    }

    private void doX() {
        System.out.print("X");
    }
}
