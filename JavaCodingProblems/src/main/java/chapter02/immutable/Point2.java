package chapter02.immutable;

public final class Point2 {

    private final double x;
    private final double y;
    private final Radius radius;

    public Point2(double x, double y, Radius radius) {
        this.x = x;
        this.y = y;

        //make clone for immutability
        Radius clone = new Radius();
        clone.setStart(radius.getStart());
        clone.setEnd(radius.getEnd());
        this.radius = clone;
        //
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Radius getRadius() {
        //same for getter make clone
        Radius clone = new Radius();
        clone.setStart(this.radius.getStart());
        clone.setEnd(this.radius.getEnd());
        return clone;
    }
}
