package adapter;

public class LineAdapter implements Shape {
    Line adapter;

    public LineAdapter(Line line) {
        adapter = line;
    }

    @Override
    public void draw(int x1, int x2, int y1, int y2) {
        adapter.draw(x1, x2, y1, y2);
    }
}
