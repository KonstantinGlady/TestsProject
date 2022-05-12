package facade;

public class Line {
    private Point o, e;

    public Line(Point ori, Point end) {
        this.o = ori;
        this.e = end;
    }

    public void move(int x, int y) {
        o.move(x, y);
        e.move(x, y);
    }

    public void rotate(int angle) {
        e.rotate(angle, o);
    }

    public String toString() {
        return "from " + o + " to " + e;
    }
}
