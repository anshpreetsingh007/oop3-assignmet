/**
 * @Author Anshpreet Singh
 *
 * Cylinder is a class that represents a cylinder shape.
 * It extends the Shape class and calculates the base area
 * and volume using the radius and height.
 */

package shapes;

public class Cylinder extends Shape {
    private final double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override public double calcBaseArea() { return Math.PI * radius * radius; }
    @Override public double calcVolume() { return calcBaseArea() * height; }
}