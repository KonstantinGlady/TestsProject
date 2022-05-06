package decorator;

public class Z extends D {
    public Z(I i) {
        super(i);
    }

    @Override
    public void doIt() {
        super.doIt();
        doZ();
    }

    private void doZ() {
        System.out.print("Z");
    }
}
