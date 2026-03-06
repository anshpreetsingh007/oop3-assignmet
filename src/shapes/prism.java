/**
 * @Author Anshpreet Singh
 *
 * Prism is an abstract class that extends Shape.
 * It represents prism-type shapes that have a base side length.
 * Other prism shapes inherit from this class.
 */


package shapes;

public abstract class prism extends Shape {
    protected double side;

    public prism(double height, double side) {
        super(height);
        this.side = side;
    }

    public double getSide() { return side; }
}