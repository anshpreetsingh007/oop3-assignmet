package shapes;

public class Pyramid extends Shape {
    private final double side;

    public Pyramid(double height, double side) {
        super(height);
        this.side = side;
    }

    @Override public double calcBaseArea() { return side * side; }
    @Override public double calcVolume() { return (calcBaseArea() * height) / 3.0; }
}