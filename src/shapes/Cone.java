/**
 * @Author Anshpreet Singh
 *
 * Cone is a class that represents a cone shape.
 * It extends the Shape class and calculates the base area
 * and volume based on the radius and height.
 */

package shapes;

public class Cone extends Shape {
    private final double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override public double calcBaseArea() { return Math.PI * radius * radius; }
    @Override public double calcVolume() { return (calcBaseArea() * height) / 3.0; }
}