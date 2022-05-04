package adapter;

public class RectangleAdapter implements Shape {
    private final Rectangle adapter;

    public RectangleAdapter(Rectangle rectangle) {
        adapter = rectangle;
    }

    @Override
    public void draw(int x1, int x2, int y1, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        adapter.draw(x, y, width, height);
    }
}
