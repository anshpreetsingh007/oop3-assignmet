/**
 * @Author Anshpreet Singh
 *
 * Pyramid is a class that represents a pyramid shape.
 * It extends the Shape class and calculates the base area
 * and volume using the side length and height.
 */

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