package facade;

public class PointPolar {
    double radius, angle;

    public PointPolar(double radius, double angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void rotate( int angle) {
        this.angle += angle % 360;
    }
    @Override
    public String toString() {
        return "[" + radius + "@" + angle + "]";
    }
}
