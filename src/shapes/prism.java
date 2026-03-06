package shapes;

public abstract class prism extends Shape {
    protected double side;

    public prism(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() { return side; }
}