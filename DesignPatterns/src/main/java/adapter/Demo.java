package adapter;

public class Demo {
    public static void main(String[] args) {

        Shape[] shapes = {new LineAdapter(new Line()), new RectangleAdapter(new Rectangle())};

        int x1 = 10, y1 = 20;
        int x2 = 30, y2 = 25;

        for (Shape s : shapes) {
            s.draw(x1, x2, y1, y2);
        }
    }

}
